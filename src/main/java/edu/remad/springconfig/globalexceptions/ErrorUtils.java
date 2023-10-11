package edu.remad.springconfig.globalexceptions;

import org.springframework.ui.ModelMap;

public final class ErrorUtils {

	private ErrorUtils() {
	}

	public static ModelMap fillExceptionModelMap(HttpStatus500Exception exception) {
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
}
