package edu.remad.springconfig.security;

import org.springframework.stereotype.Component;

@Component
public class ContentSecurityPolicySettings {
	
	private final String contentSecurityPolicies;
	
	ContentSecurityPolicySettings() {
		contentSecurityPolicies = contentSecurityCustomizer();
	}

	private String contentSecurityCustomizer() {
		StringBuilder contenSecurityPolicies = new StringBuilder();
		contenSecurityPolicies.append("style-src http://localhost:8080 'nonce-hdhjdgvsfcsvhdsfv';");
		contenSecurityPolicies.append("font-src 'self' http://localhost:8080;");
		contenSecurityPolicies.append("img-src 'self' http://localhost:8080;");
		contenSecurityPolicies.append("media-src 'self' http://localhost:8080;");
		contenSecurityPolicies.append("object-src 'self' http://localhost:8080;");
		contenSecurityPolicies.append("frame-src 'self' http://localhost:8080;");
		contenSecurityPolicies.append("frame-ancestors 'self' http://localhost:8080;");
		contenSecurityPolicies.append("script-src 'self' http://localhost:8080;");
		
		return contenSecurityPolicies.toString();
	}

	public String getContentSecurityPolicies() {
		return contentSecurityPolicies;
	}
}
