package com.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.taskmanager.model.User;
import com.fse.taskmanager.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/users"})
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public User create(@RequestBody User user){
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<User> findAll(){
		return userService.getUserDetails();
	}
}
