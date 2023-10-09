package edu.remad.springconfig.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.filter.GenericFilterBean;

public class TenantFilter extends GenericFilterBean {
	
	private static final String IPV6_LOCALHOST = "0:0:0:0:0:0:0:1";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String tenantId = ((HttpServletRequest)request).getHeader("X-Tenant-Id");

		if (!(request.getRemoteAddr().contentEquals("127.0.0.1") || request.getRemoteAddr().equals(IPV6_LOCALHOST)) || tenantId != null ){
			throw new AccessDeniedException("Your IP-address is not allowed");
		}
		
		chain.doFilter(request, response);
	}
}
