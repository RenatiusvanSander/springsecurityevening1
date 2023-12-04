package edu.remad.springconfig.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.remad.springconfig.models.ExampleModel;

@Configuration
@RequestMapping("/project")
public class NegotiationViewResolverExampleController {

	@ResponseBody
	@RequestMapping(value = "/api/{exampleModelId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public ExampleModel findExampleModel(@PathVariable Long exampleModelId) {
		if (exampleModelId >= 0) {
			ExampleModel exampleModel = new ExampleModel();
			exampleModel.setTitle("NegotiationModel Example");
			exampleModel.setViewExample("Wonderful superb view");

			return exampleModel;
		}

		return new ExampleModel();
	}
}
