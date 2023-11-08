package edu.remad.springconfig.webappinitializing;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import edu.remad.springconfig.security.config.CorsSecurityConfig;
import edu.remad.springconfig.security.config.JPASecurityConfig;
import edu.remad.springconfig.security.config.JdbcSecurityConfiguration;
import edu.remad.springconfig.security.config.SpringSecurityConfig;
import edu.remad.springconfig.mvcconfig.LocaleResolverConfig;
import edu.remad.springconfig.mvcconfig.WebMvcConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringSecurityConfig.class, JdbcSecurityConfiguration.class, JPASecurityConfig.class,
				LocaleResolverConfig.class, CorsSecurityConfig.class, WebMvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
