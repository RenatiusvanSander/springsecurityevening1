package edu.remad.springconfig.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import edu.remad.springconfig.mvcconfig.LocaleResolverConfig;
import edu.remad.springconfig.mvcconfig.WebMvcConfig;
import edu.remad.springconfig.security.config.CorsSecurityConfig;
import edu.remad.springconfig.security.config.JPASecurityConfig;
import edu.remad.springconfig.security.config.JdbcSecurityConfiguration;
import edu.remad.springconfig.security.config.SpringSecurityConfig;
import edu.remad.springconfig.testconfig.Junit5ControllerConfig;

//@SpringBootTest
@Disabled
@WebMvcTest(BasicController.class)
@ContextConfiguration(classes = { Junit5ControllerConfig.class })
public class BasicControllerTest /*extends SpringCoreJUnit5IntegrationTest */ { 
	
	@Autowired
    private MockMvc mockMvc;
	
//	@BeforeEach
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup( 
//		        new BasicController()) 
//		        .build();
//	}
    
	@Disabled
    @Test 
    public void basicControllerShouldReturnViewnameTest() throws Exception { 
      this.mockMvc 
      .perform( 
      get("/welcome") 
      .accept(MediaType.parseMediaType 
      ("application/html;charset=UTF-8"))) 
      .andExpect(status().isOk()) 
      .andExpect( content().contentType 
      ("application/html;charset=UTF-8")) 
      .andExpect(content(). 
       string("Welcome to Spring MVC")); 
    }
   }