package com.petcare.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.entities.User;
import com.petcare.services.AuthService;
import com.petcare.services.UserService;

@RestController
//@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4350" })
public class UserController {
	@Autowired
	private UserService svc;

	@Autowired
	private AuthService authService;
	
	
	@GetMapping("api/users")
	public List<User> allUsers(HttpServletResponse res, Principal principal){
		List<User> users = null;
		
		User loggedIn = svc.getUserByEmail(principal.getName());
		
		if (loggedIn.getRole().equals("staff") || loggedIn.getRole().equals("admin")){
			users = svc.getAllUsers();
			
		}
		else {
			res.setStatus(400);
		}
		
		
		
		return users;
		
		
	}
}