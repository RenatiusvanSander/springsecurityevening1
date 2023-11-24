package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/welcome")
public class BasicController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring MVC";
	}
}