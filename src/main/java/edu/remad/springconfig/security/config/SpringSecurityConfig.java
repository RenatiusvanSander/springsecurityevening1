package edu.remad.springconfig.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


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
     * Users stores credentials and roles in memory of server.
     * Reorganize into own service class!
     * 
     * @return service tells user details
     */
    @Bean
    public InMemoryUserDetailsManager users() {
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			
			UserDetails user = User.builder()
				.username("user")
				.password(encoder.encode("dummy"))
				.roles("USER")
				.build();
			UserDetails admin = User.builder()
				.username("admin")
				.password(encoder.encode("adminDummy"))
				.roles("USER", "ADMIN")
				.build();
			
			return new InMemoryUserDetailsManager(user, admin);
    }
}
