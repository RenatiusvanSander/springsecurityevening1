package edu.remad.springconfig.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

import edu.remad.springconfig.appconstants.RegexAppConstants;

public class SecuritySignupFilter implements AsyncHandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String username = request.getParameter("username");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");

		if (!Pattern.matches(RegexAppConstants.EMAIL_REGEX, emailAddress)
				|| !Pattern.matches(RegexAppConstants.PASSWORD_REGEX, password)
				|| !Pattern.matches(RegexAppConstants.USERNAME_REGEX, username)) {
			throw new Exception("Invalid E-Mail Address, Username or Password. Please try again.");
		}

		return true;
	}
}
