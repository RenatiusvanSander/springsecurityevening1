package edu.remad.springconfig.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class HitCounter {

	private int hits;

	public HitCounter() {
		System.out.println("Hit Counter instantiated");
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
}
