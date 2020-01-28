package com.petcare.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.entities.User;
import com.petcare.services.AuthService;
import com.petcare.services.UserService;

@RestController
@CrossOrigin({ "*", "http://localhost:4350" })
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService svc;

	@PostMapping("/register")
	public User register(@RequestBody User user, HttpServletResponse res) {

		if (!authService.isUserEmailUnique(user.getEmail())) {
			user = null;

		}

		if (user == null) {
			res.setStatus(400);
			return null;
		}

		user = authService.register(user);
		return user;
	}

	@GetMapping("/authenticate")
	public Principal authenticate(Principal principal) {
		
		User loggedInUser = svc.getUserByEmail(principal.getName());
		if(!loggedInUser.isEnabled()) {
			principal = null;
		}
		
		return principal;
	}

}
