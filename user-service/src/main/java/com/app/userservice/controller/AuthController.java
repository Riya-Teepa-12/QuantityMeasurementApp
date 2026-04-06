package com.app.userservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.userservice.dto.SignInDto;
import com.app.userservice.dto.SignUpDto;
import com.app.userservice.entity.User;
import com.app.userservice.service.AuthService;
import com.app.userservice.util.JwtUtil;


@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private AuthController(AuthService service) {
		this.service=service;
	}

	
	@PostMapping("/signup")
	public String signup(@RequestBody SignUpDto dto) {
		User user=new User();
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		if(dto.getPassword().length()<7) {
			return "Password must be of 8 Character";
		}
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setProvider("LOCAL");
		return service.create(user);
	}
	
	@PostMapping("/signin")
	public String login(@RequestBody SignInDto dto) {
		System.out.println("login called");
		return service.login(dto.getEmail(),dto.password);
	}
	@GetMapping("/success")
	public String success(@RequestParam String token) {
	    return " Login successful! Your JWT token is:\n\n" + token;
	}
	
	@PostMapping("/logout")
	public String logout() {
	    return "Logout successful";
	}
	@GetMapping("/profile")
	public User profile(@RequestHeader("Authorization") String token) {
		 if (token == null || !token.startsWith("Bearer ")) {
		        throw new RuntimeException("Invalid token");
		    }
	    String jwt = token.substring(7);
	    if (!jwtUtil.validateToken(jwt)) {
	        throw new RuntimeException("Token expired or invalid");
	    }
	    String email = jwtUtil.extractEmail(jwt);
	    return service.getUserByEmail(email);
	}
	
	@GetMapping("/session")
	public String session(@RequestHeader("Authorization") String token) {
	    if (token == null || !token.startsWith("Bearer ")) {
	        return "Invalid session";
	    }
	    return "Session active";
	}
	
	
}