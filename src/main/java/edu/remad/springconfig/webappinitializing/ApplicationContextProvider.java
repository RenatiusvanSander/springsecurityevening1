package edu.remad.springconfig.webappinitializing;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware{

	private ApplicationContext tutoringWebApplicationContext;
	
	public ApplicationContext getApplicationContext() {
        return tutoringWebApplicationContext;
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		tutoringWebApplicationContext = applicationContext;
	}
}
