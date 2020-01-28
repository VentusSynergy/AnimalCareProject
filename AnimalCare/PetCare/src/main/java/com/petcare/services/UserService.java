package com.petcare.services;

import java.util.List;

import com.petcare.entities.User;

public interface UserService {
	
	
	public User getUserByEmail(String email);
	
	public List<User> getAllUsers();

	public User updateUser(User u, int uid);



}
