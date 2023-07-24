package edu.remad.springconfig.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(mvcHandlerMappingIntrospector());

		return http.csrf(csrf -> csrf.disable()).authorizeRequests(auth -> {
			auth.requestMatchers(mvcMatcherBuilder.pattern("/")).permitAll();
			auth.requestMatchers(mvcMatcherBuilder.pattern("/helloWorld")).hasRole("USER");
			auth.requestMatchers(mvcMatcherBuilder.pattern("/hello")).hasRole("ADMIN");
		}).httpBasic(Customizer.withDefaults()).build();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.antMatchers("/").hasRole("USER"));

		return http.build();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {
		MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

		return http.csrf(AbstractHttpConfigurer::disable).formLogin(Customizer.withDefaults())
				.authorizeHttpRequests(
						requests -> requests.requestMatchers(mvcMatcherBuilder.pattern("/WEB-INF/index.jsp"))
								.permitAll().requestMatchers(mvcMatcherBuilder.pattern("/helloWorld")).hasRole("ADMIN")
								.requestMatchers(mvcMatcherBuilder.pattern("/hello")).hasAnyRole("ADMIN", "USER")
								.requestMatchers(mvcMatcherBuilder.pattern("/bye")).hasAnyRole("USER").anyRequest()
								.authenticated())
				.logout(Customizer.withDefaults()).build();
	}

	@Bean
	HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}
}
