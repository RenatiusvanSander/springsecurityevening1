package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/logoutSuccess")
	@ResponseBody
	public String logoutSuccess() {
		return "You are logged out";
	}
}
