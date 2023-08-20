package edu.remad.springconfig.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.mysql.cj.jdbc.Driver;

import edu.remad.springconfig.services.impl.CustomJpaUserDetailsService;

@Configuration
public class JdbcSecurityConfiguration {

	@Value("${spring.websecurity.debug:true}")
	boolean webSecurityDebug;

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.debug(webSecurityDebug);
	}

	@Bean
	public DataSource createDataSource() {
	    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	    dataSource.setDriverClass(Driver.class);
	    dataSource.setUrl("jdbc:mysql://localhost:3306/development001");
	    dataSource.setUsername("springjdbcdevelopment001");
	    dataSource.setPassword("dev0018524");
	    
	    return dataSource;
	}

	@Bean
	DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/development001", "springjdbcdevelopment001",
				"dev0018524");
	}
	
//	@Bean
//	public JdbcUserDetailsManager users(DataSource dataSource, PasswordEncoder encoder) {
//		UserDetails admin = User.builder().username("admin").password(encoder.encode("dummyAdmin")).roles("ADMIN").build();
//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//		try {
//			jdbcUserDetailsManager.createUser(admin);
//		} catch(CannotGetJdbcConnectionException ex) {
//			System.out.println("#############################");
//			System.out.println("# admin exists in data base #");
//			System.out.println("#############################");
//		}
//		
//		return jdbcUserDetailsManager;
//	}
	
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
        .antMatchers("/","/helloWorld", "/logoutSuccess","/signup").permitAll()
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
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authManager(HttpSecurity http, DataSource dataSource, PasswordEncoder passwordEncoder, CustomJpaUserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
        
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider);
        
        return authenticationManagerBuilder.build();
    }
}
