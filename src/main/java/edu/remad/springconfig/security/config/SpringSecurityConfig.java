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
				.password("{bcrypt}$2a$10$kLtNvCSnOilfMnmIt8mtI.D0dp231FuXA1VpNvjqxGiU1NVZ.oh1C").roles("USER").build();
		UserDetails admin = User.builder().username("admin")
				.password("{bcrypt$2a$10$akAbLTt.i2mgafoQiilXsOfch7KtbvKrEO63xdefM/6qI8f/wTp5S").roles("USER", "ADMIN")
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
        .antMatchers("/","/helloWorld").permitAll()
        .antMatchers("/hello","/bye","/login","/logout").authenticated()
        .antMatchers("/myCustomLogin").permitAll()
        .and().formLogin().and()
        .httpBasic();
		
		return http.build();
	}
}
