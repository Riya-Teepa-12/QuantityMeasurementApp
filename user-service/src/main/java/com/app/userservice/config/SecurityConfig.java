package com.app.userservice.config;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.userservice.util.OAuth2SuccessHandler;

@Configuration
public class SecurityConfig {
	
	   @Autowired
	    private OAuth2SuccessHandler successHandler;

	   @Bean
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	       http
	           .csrf(csrf -> csrf.disable())
	           .authorizeHttpRequests(auth -> auth
	        		   .requestMatchers("/actuator/**").permitAll() 
	               .requestMatchers("/auth/**", "/oauth2/**", "/login/**").permitAll()
	               .anyRequest().authenticated()
	           )
	           .exceptionHandling(ex -> ex
	               .authenticationEntryPoint((request, response, authException) -> {
	                   response.setStatus(401);
	                   response.setContentType("application/json");
	                   response.getWriter().write("{\"error\": \"Unauthorized\"}");
	               })
	           )
	           .oauth2Login(oauth -> oauth
	               .successHandler(successHandler)
	           );

	       return http.build();
	   }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}