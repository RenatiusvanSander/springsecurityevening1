package edu.remad.springconfig.security.logout;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

public class WebLogoutHandler implements LogoutHandler{
	
	private List<Cookie> cookies;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		cookies = Arrays.asList(request.getCookies()); // cookies to clear

		ClearSiteDataHeaderWriter clearSiteData = new ClearSiteDataHeaderWriter();
	}

}
