package edu.remad.springconfig.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler(value = IllegalStateException.class)
	public ModelAndView handleException(HttpServletRequest request, IllegalStateException ex) {
		logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURL());
		mav.setViewName("common/spring-mvc-error");
		
		return mav;
	}
}