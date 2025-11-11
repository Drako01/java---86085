package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.coderhouse.models.User;
import com.coderhouse.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserControllerApi {

	@Autowired
	private UserService svc;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getAllusers() {
		try {
			List<User> users = svc.getAll();
			return ResponseEntity.ok(users);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (HttpClientErrorException e) {
			return e.getStatusCode().value() == HttpStatus.NOT_FOUND.value() 
					? ResponseEntity.notFound().build()
					: ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		try {
			User user = svc.getById(id);
			return ResponseEntity.ok(user);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (HttpClientErrorException e) {
			return e.getStatusCode().value() == HttpStatus.NOT_FOUND.value() 
					? ResponseEntity.notFound().build()
					: ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PostMapping(value = "/", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User userCreated = svc.create(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); //201
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (HttpClientErrorException e) {
			return e.getStatusCode().value() == HttpStatus.NOT_FOUND.value() 
					? ResponseEntity.notFound().build()
					: ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
		try {
			user.setId(id);
			User updateCreated = svc.update(user);
			return ResponseEntity.ok(updateCreated); // 200
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (HttpClientErrorException e) {
			return e.getStatusCode().value() == HttpStatus.NOT_FOUND.value() 
					? ResponseEntity.notFound().build()
					: ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		try {
			svc.delete(id);
			return ResponseEntity.noContent().build(); // 204
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // 404
		} catch (HttpClientErrorException e) {
			return e.getStatusCode().value() == HttpStatus.NOT_FOUND.value() 
					? ResponseEntity.notFound().build()
					: ResponseEntity.status(e.getStatusCode()).build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build(); // 500
		}
	}
}
