package com.stautisabela.completespringbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stautisabela.completespringbootapi.data.vo.v1.UserVO;
import com.stautisabela.completespringbootapi.service.UserService;
import com.stautisabela.completespringbootapi.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/v1/user")
@Tag(name = "Users", description = "Endpoint for managing users.")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value="/all",
				produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Finds all Users",
				description = "Finds all Users",
				tags = {"Users"},
				responses = {
					@ApiResponse(description = "Success", responseCode = "200",
								content = {
									@Content(
										mediaType = "application/json",
										array = @ArraySchema(schema = @Schema(implementation = UserVO.class)))}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public List<com.stautisabela.completespringbootapi.data.vo.v1.UserVO> findAll() {
		return service.findAll();
	}
	
	
	@CrossOrigin(origins = "http://localhost:8080") // enabling CORS
	@GetMapping(value="/{id}",
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Finds a User",
	description = "Finds a User by sending its ID.",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = UserVO.class))),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public UserVO findById(@PathVariable String id) {
		return service.findById(id);
	}
	
	
	@CrossOrigin(origins = "http://localhost:8080") // enabling CORS
	@PostMapping(value="/new",
				 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
				 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Creates a new User",
	description = "Creates a new User by sending a JSON, XML or YML representation of the object.",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = UserVO.class))),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public UserVO create(@RequestBody UserVO user) {
		return service.create(user);
	}
	
	
	@PutMapping(value="/{id}",
				produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML},
				consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Updates a User",
	description = "Updates a User by sending a JSON, XML or YML representation of the object.",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "Updated", responseCode = "200",
					content = @Content(schema = @Schema(implementation = UserVO.class))),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public UserVO update(@RequestBody UserVO user) {
		return service.update(user);
	}
	
	
	@PatchMapping(value="/activate/{id}",
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Activates a User",
	description = "Activates a User by sending its ID.",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = UserVO.class))),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public UserVO activateUser(@PathVariable String id) {
		return service.findById(id);
	}
	
	
	@PatchMapping(value="/deactivate/{id}",
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YAML})
	@Operation(summary = "Disactivates a User",
	description = "Disactivates a User by sending its ID.",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = UserVO.class))),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public UserVO disactivateUser(@PathVariable String id) {
		return service.findById(id);
	}
	
	
	@DeleteMapping(value="/{id}")
	@Operation(summary = "Deletes a User",
	description = "Deletes a User",
	tags = {"Users"},
	responses = {
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
