package edu.remad.springconfig.globalexceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		ModelMap modelMap = ErrorUtils.fillExceptionModelMap(exception);
		String templateViewName = exception instanceof HttpStatusException
				? ((HttpStatusException) exception).getTemplate()
				: Error.HTTP_500_ERROR.getTemplate();
		HttpStatus status = exception instanceof HttpStatusException
				? ((HttpStatusException) exception).getHttpStatus()
				: Error.HTTP_500_ERROR.getHttpStatus();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(modelMap);
		modelAndView.setViewName(templateViewName);
		modelAndView.setStatus(status);

		return modelAndView;
	}
}
