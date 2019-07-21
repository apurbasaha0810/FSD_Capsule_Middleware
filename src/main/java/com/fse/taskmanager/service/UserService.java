package com.fse.taskmanager.service;

import java.util.List;

import com.fse.taskmanager.model.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> getUserDetails();
}
