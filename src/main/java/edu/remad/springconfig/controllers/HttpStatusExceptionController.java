package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.remad.springconfig.globalexceptions.Error;
import edu.remad.springconfig.globalexceptions.ErrorInfo;
import edu.remad.springconfig.globalexceptions.ErrorUtils;
import edu.remad.springconfig.globalexceptions.HttpStatus401Exception;
import edu.remad.springconfig.globalexceptions.HttpStatus403Exception;
import edu.remad.springconfig.globalexceptions.HttpStatus404Exception;
import edu.remad.springconfig.globalexceptions.HttpStatus500Exception;

@Controller
@RequestMapping(HttpStatusExceptionController.REQUEST_MAPPING_EXCEPTIONS)
public class HttpStatusExceptionController {

	private static final String GET_MAPPING_401 = "/401";
	private static final String GET_MAPPING_403 = "/403";
	private static final String GET_MAPPING_404 = "/404";
	private static final String GET_MAPPING_500 = "/500";
	private static final String GET_API_ERROR = "/api-error";
	public static final String REQUEST_MAPPING_EXCEPTIONS = "/exceptions";

	@GetMapping(value = GET_MAPPING_500)
	public String executeHttpStatus500Exception() {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_500;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_500_ERROR, "Test HTTP Status 500", "HTTP 500 thrown");
		
		throw new HttpStatus500Exception("Upps here happened a Http Status 500 error", new Throwable(), errorInfo);
	}
	
	@GetMapping(value = GET_MAPPING_401)
	public String executeHttpStatus401Exception() {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_401;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_401_ERROR, "Test HTTP Status 401", "HTTP 401 thrown");
		
		throw new HttpStatus401Exception("Upps, you are unauthorized..", new Throwable(), errorInfo);
	}

	@GetMapping(value = GET_MAPPING_403)
	public String executeHttpStatus403Exception() {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_403;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_403_ERROR, "Test HTTP Status 403", "HTTP 403 thrown");
		
		throw new HttpStatus403Exception("Upps, access to page is forbidden.", new Throwable(), errorInfo);
	}
	
	@GetMapping(value = GET_MAPPING_404)
	public String executeHttpStatus404Exception() {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_404;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_404_ERROR, "Test HTTP Status 404", "HTTP 404 thrown");
		
		throw new HttpStatus404Exception("Upps the page was not found.", new Throwable(), errorInfo);
	}
	
	@GetMapping(value = GET_API_ERROR)
	public String getApiError(@ModelAttribute("model") ModelMap model) {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_500;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_500_ERROR, "Test HTTP Status 500", "HTTP 500 thrown");
		HttpStatus500Exception ex = new HttpStatus500Exception("Upps here happened a Http Status 500 error", new Throwable(), errorInfo);
		model.addAllAttributes(ErrorUtils.fillExceptionModelMap(ex));
		
		return ex.getTemplate();
	}
}
