package edu.remad.springconfig.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.dto.UserDto;
import edu.remad.springconfig.globalexceptions.Error;
import edu.remad.springconfig.globalexceptions.ErrorInfo;
import edu.remad.springconfig.globalexceptions.HttpStatus404Exception;
import edu.remad.springconfig.globalexceptions.HttpStatus500Exception;
import edu.remad.springconfig.services.EmailService;
import edu.remad.springconfig.services.UserService;
import edu.remad.springconfig.services.VerificationLinkCreationService;
import edu.remad.springconfig.services.VerificationService;
import edu.remad.springconfig.services.impl.EmailServiceImpl;

@Controller
public class LoginController {

	private static final String PROCESS_SIGNUP = "/process-signup";

	public static final String SIGNUP = "/signup";

	public static final String ACTIVATE_SIGNUP = "/activate-signup";
	
	public static final String VERIFICATION_EMAIL_TEMPLATE_NAME = "verification-email.ftl";

	private UserService userService;

	private EmailService emailService;
	
	private VerificationLinkCreationService verificationLinkCreationService;
	
	private VerificationService verificationService;

	@Autowired
	public LoginController(UserService userService, EmailService emailService, VerificationLinkCreationService verificationLinkCreationService, VerificationService verificationService) {
		this.userService = userService;
		this.emailService = emailService;
		this.verificationLinkCreationService = verificationLinkCreationService;
		this.verificationService = verificationService;
	}

	@GetMapping("/myCustomLogin")
	public String formLogin() {
		return "login";
	}

	@GetMapping(SIGNUP)
	public String signUp(@ModelAttribute("signupdto") SignupDto signupDto) {
		return "signup";
	}

	@PostMapping(PROCESS_SIGNUP)
	public String processSignUp(@Valid SignupDto signupDto) {

		if (userService.isUserExisting(signupDto.getUsername())) {
			return "redirect:/myCustomLogin";
		}

		RegistrationDto registrationDto = RegistrationDto.builder().username(signupDto.getUsername())
				.email(signupDto.getEmail()).password(signupDto.getPassword()).build();

		System.out.println("###### registrationDto" + registrationDto);
		System.out.println("signupDto zum Speichern" + signupDto);
		userService.saveUser(registrationDto);

		try {
			Map<String, Object> templateModel = verificationLinkCreationService.createVerficationLinkHtml(signupDto.getEmail());
			//emailService.sendSimpleMessage(signupDto.getEmail(), "Benutzer ist registriert!",
				//	"Nachricht ist gesendet.");
			emailService.sendMessageUsingFreemarkerTemplate(signupDto.getEmail(), EmailServiceImpl.VERIFICATION_LINK_SUBJECT, VERIFICATION_EMAIL_TEMPLATE_NAME, templateModel);
		} catch (Exception ex) {
			String additionalText = "Mailer had error in sending activation e-mail.";
			ErrorInfo info = new ErrorInfo(PROCESS_SIGNUP, Error.HTTP_500_ERROR, additionalText, ex.getMessage());
			throw new HttpStatus500Exception(ACTIVATE_SIGNUP, ex.getCause(), info);
		}

		return "redirect:/myCustomLogin";
	}

	@GetMapping("/get-login-users")
	@Secured("USER")
	public ModelAndView getLoginUsers() {
		List<UserDto> users = userService.getAllUsers();

		ModelAndView model = new ModelAndView("show-users");
		model.addObject("users", users);

		return model;
	}
	
	@GetMapping(ACTIVATE_SIGNUP)
	public String activateSignup(@RequestParam(required = true) String verificationNumber) {
		boolean isVerified = verificationService.isVerified(verificationNumber);
		
		if(isVerified) {
			String email = verificationService.getEmail(verificationNumber);
			userService.activateUser(email);
		} else {
			ErrorInfo errorInfo = new ErrorInfo(ACTIVATE_SIGNUP, Error.HTTP_404_ERROR, "Was never signed up", "Error: User was never signed up!");
			throw new HttpStatus404Exception("Please sign up again. Your verification was not found.", new Throwable(), errorInfo);
		}
		
		return "activated-signup";
	}
}
