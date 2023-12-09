package edu.remad.springconfig.globalexceptions;

import org.springframework.ui.ModelMap;

import edu.remad.springconfig.models.ErrorMessage;

public final class ErrorUtils {

	private ErrorUtils() {
	}

	public static ModelMap fillExceptionModelMap(HttpStatusException exception) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("code", exception.getCode());
		modelMap.addAttribute("email", exception.getEMail());
		modelMap.addAttribute("localizedMessage", exception.getLocalizedMessage());
		modelMap.addAttribute("message", exception.getMessage());
		modelMap.addAttribute("url", exception.getUrl());
		modelMap.addAttribute("error", exception.getError().getError());
		modelMap.addAttribute("httpStatus", exception.getError().getHttpStatus().name());

		return modelMap;
	}

	public static ErrorMessage fillErrorMessage() {
		ErrorMessage em = new ErrorMessage();
		em.setCode("Code");
		em.setEmail("remad@web.de");
		em.setError("error");
		em.setMessage("message");
		em.setHttpStatus("HTTP 500");
		em.setLocalizedMessage("Localized Message");
		em.setUrl("url");

		return em;
	}
	
	public static ErrorMessage fillErrorMessage(HttpStatusException exception) {
		ErrorMessage em = new ErrorMessage();
		em.setCode(exception.getCode());
		em.setEmail(exception.getEMail());
		em.setError(exception.getError().getError());
		em.setMessage(exception.getMessage());
		em.setHttpStatus(exception.getHttpStatus().name());
		em.setLocalizedMessage(exception.getLocalizedMessage());
		em.setUrl(exception.getUrl());

		return em;
	}
}
