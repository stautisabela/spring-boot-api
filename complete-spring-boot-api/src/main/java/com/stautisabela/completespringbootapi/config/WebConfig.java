package com.stautisabela.completespringbootapi.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.stautisabela.completespringbootapi.config.converter.YamlJackson2HttpMessageConverter;


// allows GET methods in json, xml and yaml
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	// Via header parameters: key = Accept, value = application/xml
		configurer.favorParameter(false)
		  .ignoreAcceptHeader(false)
		  .useRegisteredExtensionsOnly(false)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("json", MediaType.APPLICATION_JSON)
		  .mediaType("xml", MediaType.APPLICATION_XML)
		  .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
		
	/* Via query parameters: ?mediaType=json or ?mediaType=xml
		configurer.favorParameter(true)
				  .parameterName("mediaType")
				  .ignoreAcceptHeader(true)
				  .useRegisteredExtensionsOnly(false)
				  .defaultContentType(MediaType.APPLICATION_JSON)
				  .mediaType("json", MediaType.APPLICATION_JSON)
				  .mediaType("xml", MediaType.APPLICATION_XML);	 
	 */
	}
}
