package com.recipe.superchef.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.superchef.entities.User;
import com.recipe.superchef.services.UserService;

@RestController
@RequestMapping("/superchef")
public class UserController {

	@Autowired
	private UserService uss;
	
	@GetMapping("/userlogin")
	public String userLogin(@RequestBody User user) {
		
		return uss.userLogin(user);
		
	}
	
	@PostMapping("/userreg")
	public String createUser(@RequestBody User user) {
		
		return uss.createUser(user);
		
	}
	
	@PatchMapping("/userupdate")
	public String updateUser(@PathVariable("emailId") String emailId,@RequestBody User user) {
		return uss.updateUser(user);
	}
	
	@DeleteMapping("/deluser/{emailId}")
	public String deleteUser(@PathVariable("emailId") String emailId) {
		System.out.println(emailId);
		return uss.deleteUser(emailId);
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return uss.getAllUsers();
	}
	
	@GetMapping("/getuser/{emailId}")
	public List<User> getUserbyEmailId(@PathVariable String emailId) {
		return uss.getUserbyEmailId(emailId);
	}
	
}
