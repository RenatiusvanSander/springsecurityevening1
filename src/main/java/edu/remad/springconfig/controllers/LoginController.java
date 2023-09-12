package edu.remad.springconfig.controllers;

import java.util.List;

import javax.mail.AuthenticationFailedException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.dto.UserDto;
import edu.remad.springconfig.services.impl.EmailServiceImpl;
import edu.remad.springconfig.services.impl.UserServiceImpl;

@Controller
public class LoginController {

	private UserServiceImpl userService;

	private EmailServiceImpl emailService;

	@Autowired
	public LoginController(UserServiceImpl userService, EmailServiceImpl emailService) {
		this.userService = userService;
		this.emailService = emailService;
	}

	@GetMapping("/myCustomLogin")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/signup")
	public String signUp(@ModelAttribute("signupdto") SignupDto signupDto) {
		return "signup";
	}

	@PostMapping("/process-signup")
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
			emailService.sendSimpleMessage(signupDto.getEmail(), "Benutzer ist registriert!",
					"Nachricht ist gesendet.");
		} catch (Exception ex) {
			System.out.println(ex);
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
}
