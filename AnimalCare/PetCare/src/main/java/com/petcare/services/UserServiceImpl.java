package com.petcare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.entities.User;
import com.petcare.repositories.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	@Override
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	
	@Override
	public User updateUser(User u, int uid) {
		User toUpdate = userRepo.findById(uid);
		
		if(toUpdate != null) {
			toUpdate.setFirstName(u.getFirstName());
			toUpdate.setLastName(u.getLastName());
			toUpdate.setEmail(u.getEmail());
			toUpdate.setPassword(u.getPassword());
			toUpdate.setEnabled(u.isEnabled());
			toUpdate.setRole(u.getRole());
			toUpdate.setPhone(u.getPhone());
			toUpdate.setAddress(u.getAddress());
		}
		userRepo.saveAndFlush(toUpdate);
		return toUpdate;
	}
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}




}
