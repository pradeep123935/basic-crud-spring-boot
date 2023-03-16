package com.example.basiccrud.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserResource {

	private UserDaoService userDaoService;
	
	
	public UserResource(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}


	@GetMapping("/users")
	public List<User> getUsersList() {
		return userDaoService.retriveUsers();
	}
	
	@GetMapping(path="/user/{id}")
	public User getUser(@PathVariable int id) {
		return userDaoService.getUserById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
	    User savedUser = userDaoService.save(user);

	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	            .path("/{id}")
	            .buildAndExpand(savedUser.getId())
	            .toUri();

	    return ResponseEntity.created(location).build();
	}
	
	@PutMapping(path="/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable int id) {
		User updatedUser = userDaoService.updateUser(id, user);

		if (updatedUser == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		boolean res = userDaoService.deleteUser(id);
		if(!res)
			return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}
	
}
