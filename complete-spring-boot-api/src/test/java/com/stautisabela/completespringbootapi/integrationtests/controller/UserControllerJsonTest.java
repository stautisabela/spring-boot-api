package com.stautisabela.completespringbootapi.integrationtests.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stautisabela.completespringbootapi.config.TestConfig;
import com.stautisabela.completespringbootapi.integrationtests.testcontainers.AbstractIntegrationTest;
import com.stautisabela.completespringbootapi.integrationtests.vo.UserVO;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerJsonTest extends AbstractIntegrationTest {
	
	private static RequestSpecification specification;
	private static ObjectMapper objectMapper;
	private static UserVO user;

	@BeforeAll
	public static void setup() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // disabling failure for lack of hateos link
		user = new UserVO();
	}
	
	@Test
	@Order(1)
	public void testCreate() throws JsonMappingException, JsonProcessingException {
		mockUser();
		
		specification = new RequestSpecBuilder()
								.addHeader(TestConfig.HEADER_PARAM_ORIGIN, "http://localhost:8080")
								.setBasePath("/v1/user")
								.setPort(TestConfig.SERVER_PORT)
								.addFilter(new RequestLoggingFilter(LogDetail.ALL))
								.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
								.build();
				
				
		var content = given().spec(specification)
						.contentType(TestConfig.CONTENT_TYPE_JSON)
						.body(user)
						.when().post()
						.then().statusCode(200).extract().body().asString();
		
		UserVO outputUser = objectMapper.readValue(content, UserVO.class);
		user = outputUser;
		
		assertNotNull(outputUser);
		assertNotNull(outputUser.getUserId());
		assertNotNull(outputUser.getFirstName());
		assertNotNull(outputUser.getLastName());
		assertNotNull(outputUser.getAddress());
		assertNotNull(outputUser.getBirthDate());
		
		assertEquals("Steve", outputUser.getFirstName());
		assertEquals("Pham", outputUser.getLastName());
		assertEquals("1429 Aspen St", outputUser.getAddress());
		assertEquals("13-05-1999", outputUser.getBirthDate());
	}

	private void mockUser() {
		user.setFirstName("Steve");
		user.setLastName("Pham");
		user.setAddress("1429 Aspen St");
		user.setBirthDate("13-05-1999");
	}
}
