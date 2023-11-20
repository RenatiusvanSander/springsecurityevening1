package edu.remad.springconfig.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import edu.remad.springconfig.repositories.UserEntityRepository;

public class CustomJpaUserDetailsServiceTest {

	@Mock
	private UserEntityRepository userRepository;
	
	@Test
	public void testArgumentConstructor() {
		assertNotNull( new CustomJpaUserDetailsService(userRepository),"CustomJpaUserDetailsService object shall not be null");
	}
	
	@Test
	public void testLoadUserByUsernameShouldReturnUserDetails() {
		
	}
}
