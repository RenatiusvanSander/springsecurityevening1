package edu.remad.springconfig.globalexceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
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
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
	@ExceptionHandler(HttpStatusCodeException.class)
	public ModelAndView handleHttpException(HttpServletRequest req, HttpStatusException exception) {
		return new ModelAndView();
	}
}
