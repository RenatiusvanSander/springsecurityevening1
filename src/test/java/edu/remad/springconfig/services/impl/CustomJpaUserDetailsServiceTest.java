package edu.remad.springconfig.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.remad.springconfig.models.Role;
import edu.remad.springconfig.models.UserEntity;
import edu.remad.springconfig.repositories.UserEntityRepository;

@ExtendWith(MockitoExtension.class)
public class CustomJpaUserDetailsServiceTest {

	@Mock
	private UserEntityRepository userRepository;
	
	@Test
	public void testArgumentConstructor() {
		assertNotNull( new CustomJpaUserDetailsService(userRepository),"CustomJpaUserDetailsService object shall not be null");
	}
	
	@Test
	public void testLoadUserByUsernameShouldReturnUserDetails() {
		CustomJpaUserDetailsService userDetailsService = new CustomJpaUserDetailsService(userRepository);
		String userName = "admin";
		List<Role> roles = List.of(new Role(123, userName, new ArrayList()));
		UserEntity user = new UserEntity();
		user.setUsername(userName);
		user.setPassword("fakePassword");
		user.setEmail("fake@fake.com");
		user.setTokens(new ArrayList<>());
		user.setRoles(roles);
		
		userDetailsService.loadUserByUsername(userName);
		//doReturn(user).when(userDetailsService).loadUserByUsername(userName);
		when(userRepository.findFirstByUsername("admin")).thenReturn(new UserEntity());
	}
}
