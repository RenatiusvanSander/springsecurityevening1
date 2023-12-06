package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(RedirectAttributesExampleController.PATH_REDIRECT_ATTRIBUTES)
public class RedirectAttributesExampleController {

	private static final String REDIRECT_WITH_ATTRIBUTES = "redirect-with-attributes";
	static final String PATH_REDIRECT_ATTRIBUTES = "/redirect-attributes";
	private static final String REDIRECT_PARAMETER_EXAMPLE_MODEL = "exampleModel";

	@RequestMapping("/example")
	public String getExample(RedirectAttributes redirectAttributes) {
		String title = "RedirectAttribute ExampleModel";
		redirectAttributes.addAttribute(REDIRECT_PARAMETER_EXAMPLE_MODEL, title);
		System.out.println("invoked getExample()");
		
		return "redirect:" + PATH_REDIRECT_ATTRIBUTES + "/redirect-with-attributes";
	}
	
	@RequestMapping(value="/" + PATH_REDIRECT_ATTRIBUTES, params=REDIRECT_PARAMETER_EXAMPLE_MODEL)
	public String getRedirectWithAttributes(Model model, @RequestParam(REDIRECT_PARAMETER_EXAMPLE_MODEL) String exampleModel) {
		System.out.println("invoked getRedirectWithAttributes()");
		model.addAttribute(REDIRECT_PARAMETER_EXAMPLE_MODEL, exampleModel);
		
		return REDIRECT_WITH_ATTRIBUTES;
	}
}
