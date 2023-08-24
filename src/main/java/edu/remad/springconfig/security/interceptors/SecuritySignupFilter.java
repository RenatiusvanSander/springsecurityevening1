package edu.remad.springconfig.security.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

import org.springframework.web.servlet.AsyncHandlerInterceptor;

public class SecuritySignupFilter implements AsyncHandlerInterceptor {

	private final static String EMAIL_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private final static String PASSWORD_REGEX = "[A-Za-z0-9-]";
	
	private final static String USERNAME_REGEX = "^[0-9_a-Z]*$";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String username = request.getParameter("username");
		String emailAddress = request.getParameter("email");
        String password = request.getParameter("password");

        if( !Pattern.matches(EMAIL_REGEX, emailAddress) || !Pattern.matches(PASSWORD_REGEX, password) || !Pattern.matches(USERNAME_REGEX, username)/*StringUtils.isEmpty(emailAddress) ||             
        StringUtils.containsWhitespace(emailAddress) ||
        StringUtils.isEmpty(password) || 
        StringUtils.containsWhitespace(password)*/) {
          throw new Exception("Invalid E-Mail Address or Password. Please try again.");
        }
		
		return true;
	}
}
