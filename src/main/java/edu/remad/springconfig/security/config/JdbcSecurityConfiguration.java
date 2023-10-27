package edu.remad.springconfig.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter.Directive;

import com.mysql.cj.jdbc.Driver;

import edu.remad.springconfig.security.filters.TenantFilter;
import edu.remad.springconfig.services.impl.CustomJpaUserDetailsService;
import edu.remad.springconfig.systemenvironment.SystemEnvironment;

@Configuration
public class JdbcSecurityConfiguration {

	@Value("${spring.websecurity.debug:true}")
	boolean webSecurityDebug;

	private static final ClearSiteDataHeaderWriter.Directive[] COOKIES = Directive.values();

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.debug(webSecurityDebug);
	}

	@Bean
	public DataSource createDataSource(SystemEnvironment systemEnvironment) {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(Driver.class);
		dataSource.setUrl(systemEnvironment.getAppDataSourcesMysqlUrl());
		dataSource.setUsername(systemEnvironment.getAppDataSourcesMysqlUsername());
		dataSource.setPassword(systemEnvironment.getAppDataSourcesMysqlPassword());

		return dataSource;
	}

	@Bean
	DataSource dataSource(SystemEnvironment systemEnvironment) {
		return new DriverManagerDataSource(systemEnvironment.getAppDataSourcesMysqlUrl(),
				systemEnvironment.getAppDataSourcesMysqlUsername(), systemEnvironment.getAppDataSourcesMysqlPassword());
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
		http.addFilterAfter(new TenantFilter(), BasicAuthenticationFilter.class)
				.securityContext((securityContext) -> securityContext.requireExplicitSave(true))
				.sessionManagement(
						session -> session.maximumSessions(1).maxSessionsPreventsLogin(true).expiredUrl("/login"))
				.authorizeRequests().antMatchers("/", "/helloWorld", "/logoutSuccess", "/signup").permitAll()
				.antMatchers("/hello", "/bye", "/login", "/logout", "/templates/**").authenticated().and().formLogin()
				.loginPage("/myCustomLogin").loginProcessingUrl("/process-login").defaultSuccessUrl("/hello", true)
				.and().csrf().and().logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccess")
						.addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(COOKIES))));
		http.httpBasic();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http, DataSource dataSource, PasswordEncoder passwordEncoder,
			CustomJpaUserDetailsService userDetailsService) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		authenticationManagerBuilder.authenticationProvider(daoAuthenticationProvider);

		return authenticationManagerBuilder.build();
	}
}
