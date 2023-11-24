package edu.remad.springconfig.testconfig;

import org.junit.jupiter.api.Disabled;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Disabled
@EnableWebMvc
@Configuration
@ComponentScan({"edu.remad.springconfig.controllers","edu.remad.springconfig.services.impl","edu.remad.springconfig.models","edu.remad.springconfig.repositories"})
public class Junit5ControllerConfig {

}
