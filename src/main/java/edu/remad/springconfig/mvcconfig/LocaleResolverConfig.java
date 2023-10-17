package edu.remad.springconfig.mvcconfig;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocaleResolverConfig {

	@Bean
	public CookieLocaleResolver cookieLocaleResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.GERMANY);

		return localeResolver;
	}

	@Bean
	public LocaleResolver localResolver() {
		List<Locale> supportedLocales = List.of(Locale.FRANCE, Locale.FRENCH, Locale.GERMAN, Locale.GERMANY, Locale.US);

		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.GERMANY);
		localeResolver.setSupportedLocales(supportedLocales);

		return localeResolver;
	}

	@Bean
	public SessionLocaleResolver sessionLocaleResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.GERMANY);
		
		return localeResolver;
	}

	@Bean
	public FixedLocaleResolver fixedLocaleResolver() {
		FixedLocaleResolver localeResolver = new FixedLocaleResolver();
		localeResolver.setDefaultLocale(Locale.GERMANY);
		
		return new FixedLocaleResolver();
	}
}
