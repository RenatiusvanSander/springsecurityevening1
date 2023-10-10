package edu.remad.springconfig.globalexceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")
	// 409
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView conflicht(HttpServletRequest req, Exception exception)
			throws Exception {
		return new ModelAndView();
	}

	@ExceptionHandler(HttpStatus500Exception.class)
	public ModelAndView handleHttpStatus500Exception(HttpStatus500Exception exception) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("exceptionContent", exception.getAdditionalText());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(modelMap);
		modelAndView.setViewName(exception.getTemplate());
		
		return modelAndView;
	}
}
