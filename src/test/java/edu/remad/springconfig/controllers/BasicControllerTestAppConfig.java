package edu.remad.springconfig.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicControllerTestAppConfig {
	
	@Bean
	public BasicController basicController() {
		return new BasicController();
	}
}
