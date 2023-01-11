package com.stautisabela.completespringbootapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// allows get methods in json and xml formats
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	/*
	 * Via query parameters: ?mediaType=json or ?mediaType=xml
	 * 
		configurer.favorParameter(true)
				  .parameterName("mediaType")
				  .ignoreAcceptHeader(true)
				  .useRegisteredExtensionsOnly(false)
				  .defaultContentType(MediaType.APPLICATION_JSON)
				  .mediaType("json", MediaType.APPLICATION_JSON)
				  .mediaType("xml", MediaType.APPLICATION_XML);	 
	*/

	// Via header parameters: key = Accept, value = application/xml
		
		configurer.favorParameter(false)
		  .ignoreAcceptHeader(false)
		  .useRegisteredExtensionsOnly(false)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("json", MediaType.APPLICATION_JSON)
		  .mediaType("xml", MediaType.APPLICATION_XML);	 
	}
}
