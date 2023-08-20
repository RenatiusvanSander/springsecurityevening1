package edu.remad.springconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.remad.springconfig.dto.RegistrationDto;
import edu.remad.springconfig.dto.SignupDto;
import edu.remad.springconfig.models.UserEntity;
import edu.remad.springconfig.services.impl.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/myCustomLogin")
	public String formLogin() {
		return "login";
	}

	@GetMapping("/signup")
	public String signUp(@ModelAttribute("signupdto") SignupDto signupDto) {
		return "signup";
	}

	@PostMapping("/process-signup")
	public String processSignUp(SignupDto signupDto) {

		if (userService.isUserExisting(signupDto.getUsername())) {
			return "redirect:/myCustomLogin";
		}

		RegistrationDto registrationDto = new RegistrationDto();
		registrationDto.setUsername(signupDto.getUsername());
		registrationDto.setEmail(signupDto.getEmail());
		registrationDto.setPassword(signupDto.getPassword());
		userService.saveUser(registrationDto);

		return "redirect:/myCustomLogin";
	}
}
