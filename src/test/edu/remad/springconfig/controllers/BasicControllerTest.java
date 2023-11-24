package edu.remad.springconfig.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import edu.remad.springconfig.controllers.BasicController;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BasicController.class)
@ContextHierarchy({
	@ContextConfiguration(classes = BasicControllerTestAppConfig.class),
	@ContextConfiguration(classes = WebConfigControllersTest.class)
})
public class BasicControllerTest { 
	
	@Autowired
    private MockMvc mockMvc;
    
    @Test 
    public void basicControllerShouldReturnViewnameTest() throws Exception { 
      ResultActions result = this.mockMvc.perform(get("/welcome").contentType(MediaType.APPLICATION_JSON));
    }
   }