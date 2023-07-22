package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello-world";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Edu.remad";
	}
	
	@ResponseBody
	@GetMapping("/bye")
	public String bye() {
		return "bye bye guys !!";
	}
}
