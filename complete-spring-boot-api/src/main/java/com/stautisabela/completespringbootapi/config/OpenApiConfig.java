package com.stautisabela.completespringbootapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	// accessible via /v3/api-docs and /swagger-ui/index.html
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Complete RESTful API with Java 18 and Spring Boot 3")
						.version("v1")
						.description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras auctor eleifend mattis.")
						.termsOfService("")
						.license(new License()
										.name("Apache 2.0")
										.url("")));
	}
}
