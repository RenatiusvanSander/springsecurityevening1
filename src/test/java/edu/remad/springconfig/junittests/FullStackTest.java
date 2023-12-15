package edu.remad.springconfig.junittests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestWebMvcConfig.class)
public class FullStackTest {
	
	@Test
	public void test() {
		System.out.println("Test has run!");
	}

}
