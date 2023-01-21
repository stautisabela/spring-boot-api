package com.stautisabela.completespringbootapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.stautisabela.completespringbootapi.config.converter.YamlJackson2HttpMessageConverter;


// allows GET methods in json, xml and yaml
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	@Value("${cors.originPatterns:default}") //can set a default value for cors.originPatters if empty in application.properties
	private String corsOriginPatterns = "";

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

	// via header parameters: key = Accept, value = application/xml
		configurer.favorParameter(false)
		  .ignoreAcceptHeader(false)
		  .useRegisteredExtensionsOnly(false)
		  .defaultContentType(MediaType.APPLICATION_JSON)
		  .mediaType("json", MediaType.APPLICATION_JSON)
		  .mediaType("xml", MediaType.APPLICATION_XML)
		  .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
		
	/* via query parameters: ?mediaType=json or ?mediaType=xml
		configurer.favorParameter(true)
				  .parameterName("mediaType")
				  .ignoreAcceptHeader(true)
				  .useRegisteredExtensionsOnly(false)
				  .defaultContentType(MediaType.APPLICATION_JSON)
				  .mediaType("json", MediaType.APPLICATION_JSON)
				  .mediaType("xml", MediaType.APPLICATION_XML);	 
	 */
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		var allowedOrigins = corsOriginPatterns.split(",");
		registry.addMapping("/**") //allows all routes within our API
				.allowedMethods("*")
				.allowedOrigins(allowedOrigins)
				.allowCredentials(true); //allows authentication
	}
}
