package edu.remad.springconfig;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

import edu.remad.springconfig.mvcconfig.LocaleResolverConfig;
import edu.remad.springconfig.mvcconfig.WebMvcConfig;
import edu.remad.springconfig.security.config.CorsSecurityConfig;
import edu.remad.springconfig.security.config.JPASecurityConfig;
import edu.remad.springconfig.security.config.JdbcSecurityConfiguration;
import edu.remad.springconfig.security.config.SpringSecurityConfig;

/**
 * Basic class for every Integration test. WebAppContext can be changed by
 * annotation to {@code @WebAppConfiguration("/src/test/webapp")}
 */
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringSecurityConfig.class, JdbcSecurityConfiguration.class, JPASecurityConfig.class,
		LocaleResolverConfig.class, CorsSecurityConfig.class, WebMvcConfig.class })
public class SpringCoreJUnit5IntegrationTest {

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	MockServletContext servletContext;

	@Autowired
	MockHttpSession session;

	@Autowired
	MockHttpServletRequest request;

	@Autowired
	MockHttpServletResponse response;

	@Autowired
	ServletWebRequest webRequest;
}
