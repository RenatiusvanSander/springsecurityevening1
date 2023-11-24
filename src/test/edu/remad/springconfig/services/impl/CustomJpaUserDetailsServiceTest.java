package edu.remad.springconfig.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.remad.springconfig.models.Role;
import edu.remad.springconfig.models.UserEntity;
import edu.remad.springconfig.mvcconfig.LocaleResolverConfig;
import edu.remad.springconfig.mvcconfig.WebMvcConfig;
import edu.remad.springconfig.repositories.UserEntityRepository;
import edu.remad.springconfig.security.config.CorsSecurityConfig;
import edu.remad.springconfig.security.config.JPASecurityConfig;
import edu.remad.springconfig.security.config.JdbcSecurityConfiguration;
import edu.remad.springconfig.security.config.SpringSecurityConfig;
@Disabled
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringSecurityConfig.class, JdbcSecurityConfiguration.class, JPASecurityConfig.class,
		LocaleResolverConfig.class, CorsSecurityConfig.class, WebMvcConfig.class })
public class CustomJpaUserDetailsServiceTest {

	@MockBean
	private UserEntityRepository userRepository;
	
	@Disabled
	@Test
	public void testArgumentConstructor() {
		assertNotNull( new CustomJpaUserDetailsService(userRepository),"CustomJpaUserDetailsService object shall not be null");
	}
	
	@Disabled
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
		when(userRepository.findFirstByUsername(anyString())).thenReturn(new UserEntity());
	}
}
