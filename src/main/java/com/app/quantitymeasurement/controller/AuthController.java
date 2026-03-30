package com.app.quantitymeasurement.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.quantitymeasurement.dto.SignInDto;
import com.app.quantitymeasurement.dto.SignUpDto;
import com.app.quantitymeasurement.entity.User;
import com.app.quantitymeasurement.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthService service;
	@Autowired
	private PasswordEncoder passwordEncoder;
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
		return service.login(dto.getEmail(),dto.password);
	}
	@GetMapping("/success")
	public String success(@RequestParam String token) {
	    return "✅ Login successful! Your JWT token is:\n\n" + token;
	}
	
	
}
