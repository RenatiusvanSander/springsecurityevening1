package edu.remad.springconfig.junittests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.remad.springconfig.mvcconfig.WebMvcConfig;

@Disabled
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebMvcConfig.class)
public class SpringJunit5Test {

	@Disabled
	@Test
	public void test() {
		System.out.println("Test");
	}
}
