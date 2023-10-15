package edu.remad.springconfig.mvcconfig;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import edu.remad.springconfig.security.interceptors.SecuritySignupFilter;
import edu.remad.springconfig.systemenvironment.SystemEnvironment;
import edu.remad.springconfig.systemenvironment.SystemEnvironmentFactory;

@EnableWebMvc
@Configuration
@ComponentScan("edu.remad.springconfig")
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		// TODO registry.addInterceptor(new LoggerInterceptor());
		// TODO registry.addInterceptor(new UserInterceptor());
		// TODO registry.addInterceptor(new SessionTimerInterceptor());
		registry.addInterceptor(new SecuritySignupFilter()).addPathPatterns("/process-signup");
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
	    props.put("mail.properties.mail.smtp.starttls.required","true");
	    props.put("mail.properties.mail.smtp.ssl.enable","false");
	    props.put("mail.properties.mail.smtp.timeout", "15000");
	    props.put("mail.properties.mail.smtp.connectiontimeout", "15000");
	    props.put("mail.properties.mail.smtp.socketFactory.fallback", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.freeMarker();
	}
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		Properties properties = new Properties();
		properties.put("auto_import", "/spring.ftl as spring");
		
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPath("/WEB-INF/templates/freemarker");
		configurer.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
		configurer.setFreemarkerSettings(properties);
		
		return configurer;
	}
	
	@Bean(name="messageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("messages/messages");
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
		
		return messageSource;
	}
}
