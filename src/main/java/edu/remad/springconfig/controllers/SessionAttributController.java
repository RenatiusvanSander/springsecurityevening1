package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/session")
@Controller
@SessionAttributes(SessionAttributController.EXAMPLE_SESSION_ATTRIBUTE)
public class SessionAttributController {

	private static final String SESSION_TEMPLATE = "session";

	public static final String EXAMPLE_SESSION_ATTRIBUTE = "exampleSessionAttribute";

	@GetMapping("/remove-session-attribute")
	public String someMethod(WebRequest request, SessionStatus status) {
		status.setComplete();
		request.removeAttribute(EXAMPLE_SESSION_ATTRIBUTE, WebRequest.SCOPE_SESSION);

		return SESSION_TEMPLATE;
	}

	@GetMapping("/cleanup-session-attribute")
	public String someOtherMethod(WebRequest request, SessionAttributeStore store, SessionStatus status) {
		status.setComplete();
		store.cleanupAttribute(request, EXAMPLE_SESSION_ATTRIBUTE);

		return SESSION_TEMPLATE;
	}
}
