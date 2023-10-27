package edu.remad.springconfig.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import edu.remad.springconfig.security.JwtAuthenticationEntryPoint;

@Configuration
public class JwtSecurityConfig {

	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public JwtSecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
		authenticationEntryPoint = jwtAuthenticationEntryPoint;
	}

	@Bean
	@Order(2)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement(
				session -> session.maximumSessions(1).maxSessionsPreventsLogin(true).expiredUrl("/login")).authorizeRequests()
				.antMatchers("/", "/helloWorld", "/logoutSuccess", "/signup", "/api/auth/**").permitAll()
				.antMatchers("/hello", "/bye", "/login", "/logout", "/templates/**")
				.authenticated().and().formLogin()
				.loginPage("/myCustomLogin").loginProcessingUrl("/process-login").defaultSuccessUrl("/hello", true)
				.and().logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess"));

		return http.build();
	}
}
