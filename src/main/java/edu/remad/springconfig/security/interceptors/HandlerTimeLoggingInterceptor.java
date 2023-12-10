package edu.remad.springconfig.security.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.remad.springconfig.tools.StopWatch;

public class HandlerTimeLoggingInterceptor implements AsyncHandlerInterceptor {
	
	private Logger logger;
	private StopWatch stopWatch;
	
	public HandlerTimeLoggingInterceptor() {
		logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.setLevel(Level.ALL);
		stopWatch = new StopWatch();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		stopWatch.start();

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("endTime", System.currentTimeMillis());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		stopWatch.stop();
		logger.info(String.format("####Time Measuring#### Time Spent in %s in ms : %d", request.getRequestURI(), stopWatch.getTime()));
		stopWatch = new StopWatch();
	}
}
