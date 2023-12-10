package edu.remad.springconfig.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.remad.springconfig.scopes.HitCounter;

@Controller
@RequestMapping("/home")
public class MainController {
	
	@Autowired
	private HitCounter hitCounter;

	@GetMapping("/")
	public String getHome() {
		hitCounter.setHits(hitCounter.getHits() + 1);
		System.out.println("The number of hits is : " + hitCounter.getHits());
		
		return "home";
	}
}
