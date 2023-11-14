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
		contenSecurityPolicies.append("style-src 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("font-src 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("img-src 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("media-src 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("object-src 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("plugin-types 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("frame-options 'self' locahost:8080, localhost");
		contenSecurityPolicies.append("script-src 'self' locahost:8080, localhost");
		
		return contenSecurityPolicies.toString();
	}

	public String getContentSecurityPolicies() {
		return contentSecurityPolicies;
	}
}
