package edu.remad.springconfig.mvcconfig;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class JulianDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String stringDate) {
		System.out.println("Converting String to date");
		Date date = null;
		
		try {
			date = new SimpleDateFormat("yyyyDDD").parse(stringDate);
		} catch (ParseException e) {
		}
		
		return date;
	}
}
