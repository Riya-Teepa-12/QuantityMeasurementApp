package com.app.quantitymeasurement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.quantitymeasurement.entity.User;
import com.app.quantitymeasurement.repository.UserRepository;
import com.app.quantitymeasurement.security.JwtUtil;

@Service
public class AuthService {
	
	private final UserRepository repository;
	private final JwtUtil util;
	@Autowired
	private PasswordEncoder passwordEncoder;
	public AuthService(UserRepository repository,JwtUtil util) {
		this.repository=repository;
		this.util=util;
	}
	
	
	
	public String create(User user) {
		if (repository.existsByEmail(user.getEmail())) {
	        throw new RuntimeException("Email already registered");
	    }
		repository.save(user);
		System.out.println("user saved:"+user.getEmail());
		return "User registered successfully";
		
	}
	
	public String login(String email,String password) {
		 User user = repository.findByEmail(email).orElseThrow(()->new RuntimeException("Invalid Username or Password"));
		    if (user == null) {
		        throw new RuntimeException("User not found");
		    }
		    if (!passwordEncoder.matches(password, user.getPassword())) {
		        throw new RuntimeException("Invalid password");
		    }
		    String token = util.generateToken(email);

		    return token;

	}

}

