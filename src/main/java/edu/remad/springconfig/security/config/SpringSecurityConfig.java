package edu.remad.springconfig.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SpringSecurityConfig {

	@Value("${spring.websecurity.debug:true}")
	boolean webSecurityDebug;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.debug(webSecurityDebug);
	}

	/**
	 * Users stores credentials and roles in memory of server. Reorganize into own
	 * service class!
	 * 
	 * @return service tells user details
	 */
	@Bean
	public InMemoryUserDetailsManager users() {
		UserDetails user = User.builder().username("user")
				.password("{bcrypt}$2a$10$HN9/XiCv48GxNh4clkzJ4.iwR59k89S8y7M4kkNBs6Q6MhTCEUb.2").roles("USER").build();
		UserDetails admin = User.builder().username("admin")
				.password("{$2a$10$2ZcGs4Wl7tBlm.4R8yqjE.MFa.awSBvBXNfKn/13KlrpzF8eEL2Om").roles("USER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		String idForEncode = "bcrypt";
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put(idForEncode, new BCryptPasswordEncoder());

		return new DelegatingPasswordEncoder(idForEncode, encoders);
	}
	
	/**
	 * Does form login filter chain and has also http security.
	 * 
	 * @param http similar to spring security xml config for filtering request
	 * @return created security filter chain, {@link SecurityFilterChain}
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(authorize -> 
//		authorize.requestMatchers("/","/helloWorld").permitAll()
//		.requestMatchers("/hello","/bye","/login","/logout").hasRole("USER").anyRequest().authenticated())
//        .formLogin().and()
//        .httpBasic();		
		http.authorizeRequests()
        .antMatchers("/","/helloWorld", "/logoutSuccess").permitAll()
        .antMatchers("/hello","/bye","/login","/logout").authenticated()
        .and()
        .formLogin()
        .loginPage("/myCustomLogin").loginProcessingUrl("/process-login").defaultSuccessUrl("/hello", true)
//        .failureUrl("/login.html?error=true")
//        .failureHandler(authenticationFailureHandler())
        .and()
        .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess")
//        .deleteCookies("JSESSIONID")
//        .logoutSuccessHandler(logoutSuccessHandler())
        .and()
        .httpBasic();
		
		return http.build();
	}
}
