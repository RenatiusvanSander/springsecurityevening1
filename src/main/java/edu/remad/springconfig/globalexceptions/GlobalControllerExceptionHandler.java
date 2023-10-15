package edu.remad.springconfig.globalexceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView conflicht(HttpServletRequest req, Exception exception)
			throws Exception {
		return new ModelAndView();
	}

	@ExceptionHandler(HttpStatus401Exception.class)
	public ModelAndView handleHttpStatus401Exception(HttpStatus401Exception exception) {
		ModelAndView modelAndView = populateModelAndView(new ModelAndView(), exception);
		
		return modelAndView;
	}
	
	@ExceptionHandler(HttpStatus403Exception.class)
	public ModelAndView handleHttpStatus403Exception(HttpStatus403Exception exception) {
		ModelAndView modelAndView = populateModelAndView(new ModelAndView(), exception);
		
		return modelAndView;
	}

	@ExceptionHandler(HttpStatus404Exception.class)
	public ModelAndView handleHttpStatus404Exception(HttpStatus404Exception exception) {
		ModelAndView modelAndView = populateModelAndView(new ModelAndView(), exception);
		
		return modelAndView;
	}
	
	@ExceptionHandler(HttpStatus500Exception.class)
	public ModelAndView handleHttpStatus500Exception(HttpStatus500Exception exception) {
		ModelAndView modelAndView = populateModelAndView(new ModelAndView(), exception);
		
		return modelAndView;
	}
	
	private ModelAndView populateModelAndView(ModelAndView view, HttpStatusException exception) {
		ModelMap modelMap = ErrorUtils.fillExceptionModelMap(exception);
		view.addAllObjects(modelMap);
		view.setViewName(exception.getTemplate());
		
		return view;
	}
}
