package com.petcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petcare.entities.User;
import com.petcare.repositories.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepo uRepo;


	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {

		String encrypted = encoder.encode(user.getPassword());
		user.setPassword(encrypted);

		user.setEnabled(true);
		

		user.setRole("patient");
		uRepo.saveAndFlush(user);
		return user;
	}

//	@Override
//	public boolean isUserUnique(String username, String email) {
//		List<User> allUsers = uRepo.findAll();
//
//		boolean isUnique = true;
//
//		for (User user : allUsers) {
//			if ((user.getEmail().equalsIgnoreCase(email)) || (user.getUsername().equalsIgnoreCase(username))) {
//				isUnique = false;
//			}
//
//		}
//
//		return isUnique;
//	}
//
//	@Override
//	public boolean isUserUsernameUnique(String username) {
//		List<User> allUsers = uRepo.findAll();
//		
//		boolean isUnique = true;
//		
//		for (User user : allUsers) {
//			if ((user.getUsername().equalsIgnoreCase(username))) {
//				isUnique = false;
//			}
//			
//		}
//		
//		return isUnique;
//	}

	@Override
	public boolean isUserEmailUnique(String email) {
		List<User> allUsers = uRepo.findAll();
		
		boolean isUnique = true;
		
		for (User user : allUsers) {
			if ((user.getEmail().equalsIgnoreCase(email))) {
				isUnique = false;
			}
			
		}
		
		return isUnique;
	}

}
