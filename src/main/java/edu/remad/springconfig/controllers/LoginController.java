package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@GetMapping("/myCustomLogin")
	public String formLogin() {
		return "login";
	}
}
