package edu.remad.springconfig.mvcconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import edu.remad.springconfig.security.interceptors.SecuritySignupFilter;


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
}
