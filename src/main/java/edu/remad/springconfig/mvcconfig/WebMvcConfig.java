package edu.remad.springconfig.mvcconfig;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import edu.remad.springconfig.security.interceptors.GlobalInterceptor;
import edu.remad.springconfig.security.interceptors.HandlerTimeLoggingInterceptor;
import edu.remad.springconfig.security.interceptors.SecuritySignupFilter;
import edu.remad.springconfig.systemenvironment.SystemEnvironment;
import edu.remad.springconfig.systemenvironment.SystemEnvironmentFactory;

@EnableWebMvc
@Configuration
@ComponentScan("edu.remad.springconfig")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new JulianDateConverter());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(1);

		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/static-resources/**").addResourceLocations("/static-resources")
				.setCachePeriod(365 * 24 * 60 * 60).resourceChain(true).addResolver(new EncodedResourceResolver())
				.addResolver(new PathResourceResolver());
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars");
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// TODO registry.addInterceptor(new LoggerInterceptor());
		// TODO registry.addInterceptor(new UserInterceptor());
		// TODO registry.addInterceptor(new SessionTimerInterceptor());
		registry.addInterceptor(new HandlerTimeLoggingInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/secure/**");
		registry.addInterceptor(new SecuritySignupFilter()).addPathPatterns("/process-signup");
		registry.addInterceptor(localeChangeInterceptor());
		registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/project/**");
	}

	@Bean
	public SystemEnvironment systemEnvironment() {
		return SystemEnvironmentFactory.getInstance();
	}

	@Bean
	public JavaMailSender createJavaMailSender(SystemEnvironment systemEnvironment) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.web.de");
		mailSender.setPort(587);
		mailSender.setUsername(systemEnvironment.getSmtpUsername());
		mailSender.setPassword(systemEnvironment.getSmtpPassword());

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.properties.mail.smtp.starttls.required", "true");
		props.put("mail.properties.mail.smtp.ssl.enable", "false");
		props.put("mail.properties.mail.smtp.timeout", "15000");
		props.put("mail.properties.mail.smtp.connectiontimeout", "15000");
		props.put("mail.properties.mail.smtp.socketFactory.fallback", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.freeMarker().cache(true).cacheLimit(1000);
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("messages/messages", "messages/welcomes");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();

		return localeChangeInterceptor;
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/cors/greeting-javaconfig").allowedOrigins("http://localhost:8080");
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).
	    favorParameter(true).
	    parameterName("format").
	    mediaType("xml", MediaType.APPLICATION_XML). 
	    mediaType("json", MediaType.APPLICATION_JSON); 
	}
}
