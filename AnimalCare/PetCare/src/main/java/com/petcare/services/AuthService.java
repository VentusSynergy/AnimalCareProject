package com.petcare.services;

import com.petcare.entities.User;

public interface AuthService {
	
	public User register(User user);
	public boolean isUserEmailUnique(String email);

}
