package edu.remad.springconfig.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.remad.springconfig.models.ExampleModel;

@Controller
@RequestMapping(RedirectFlashAttributesExampleController.PATH_REDIRECT_FLASH_ATTRIBUTES)
public class RedirectFlashAttributesExampleController {

	private static final String PATH_REDIRECTION = "/redirection";
	static final String PATH_REDIRECT_FLASH_ATTRIBUTES = "/redirect-flash-attributes";
	private static final String FLASH_ATTRIBUTE_EXAMPLE_MODEL = "exampleModel";

	@RequestMapping("/example")
	public String getFlashAttributes(RedirectAttributes redirectAttributes) {
		ExampleModel em = new ExampleModel();
		em.setTitle("RedirectAttribute ExampleModel");
		em.setViewExample("redirect-with-attributes");
		redirectAttributes.addFlashAttribute(FLASH_ATTRIBUTE_EXAMPLE_MODEL, em);

		return "redirect:" + PATH_REDIRECT_FLASH_ATTRIBUTES + PATH_REDIRECTION;
	}

	@RequestMapping(PATH_REDIRECTION)
	public String getRedirection(Model model,
			@ModelAttribute(FLASH_ATTRIBUTE_EXAMPLE_MODEL) ExampleModel exampleModel) {
		model.addAttribute(FLASH_ATTRIBUTE_EXAMPLE_MODEL, exampleModel);

		return "flash-attributes";
	}
}
