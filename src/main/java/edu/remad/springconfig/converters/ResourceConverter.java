package edu.remad.springconfig.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.remad.springconfig.models.Resource;

@Component
public class ResourceConverter implements Converter<String, Resource> {

	@Override
	public Resource convert(String source) {
		Resource resource = new Resource();
		resource.setSource(source);
		
		return resource;
	}

}
