package edu.remad.springconfig.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cors")
public class CrossOriginResourceSharingController {

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/corsorigin")
	public String getCorsOrigin() {
		return "corsorigin";
	}
	
	@GetMapping("/greeting-javaconfig")
	public String greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
		return "corsorigin";
	}
}
