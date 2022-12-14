package com.dgsh.rest.web.services.restfulwebservices.user;


import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserDaoService userDaoService;

	// Get All User
	@GetMapping("/users")
	public List<User> findAll() {
		return userDaoService.findAll();
	}

	// Get Single USer
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable("id") int id) {
		User user= userDaoService.findUserById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		//HATEOAS
		return user;
	}

	// Save User
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser= userDaoService.saveUser(user);
		//CREATED
		// /users/{id}		savedUser.getId()
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	// Delete User
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		User user= userDaoService.deleteById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
	}
	
	
	//Intenationalization localeSources
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	
	

}
