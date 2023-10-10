package edu.remad.springconfig.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.remad.springconfig.globalexceptions.Error;
import edu.remad.springconfig.globalexceptions.ErrorInfo;
import edu.remad.springconfig.globalexceptions.HttpStatus500Exception;

@Controller
@RequestMapping(HttpStatusExceptionController.REQUEST_MAPPING_EXCEPTIONS)
public class HttpStatusExceptionController {

	private static final String GET_MAPPING_500 = "/500";
	private static final String GET_API_ERROR = "/api-error";
	private static final String REQUEST_MAPPING_EXCEPTIONS = "/exceptions";

	@GetMapping(value = GET_MAPPING_500)
	public String executeHttpStatus500Exception(@ModelAttribute("model") ModelMap model) {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_500;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_500_ERROR, "Test HTTP Status 500", "HTTP 500 thrown");
		
		HttpStatus500Exception exception = new HttpStatus500Exception("Upps here happened a Http Status 500 error", new Throwable(), errorInfo);
		List<HttpStatus500Exception> exceptionContent = new ArrayList<>();
		exceptionContent.add(exception);
		model.addAttribute("exceptionContent", exceptionContent);
		
		throw exception;
	}
	
	@GetMapping(value = GET_API_ERROR)
	public String getApiError(@ModelAttribute("model") ModelMap model) {
		String url = REQUEST_MAPPING_EXCEPTIONS + GET_MAPPING_500;
		ErrorInfo errorInfo = new ErrorInfo(url, Error.HTTP_500_ERROR, "Test HTTP Status 500", "HTTP 500 thrown");
		HttpStatus500Exception ex = new HttpStatus500Exception("Upps here happened a Http Status 500 error", new Throwable(), errorInfo);
		
		model.addAttribute("exceptionContent", ex.getAdditionalText());
		
		return "api-error";
	}
}
