package com.app.quantitymeasurement.config;

import org.springframework.security.core.Authentication;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.app.quantitymeasurement.security.JwtUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws java.io.IOException {

        try {
            OAuth2User user = (OAuth2User) authentication.getPrincipal();
            String email = user.getAttribute("email");
            System.out.println("email"+email);

            String token = jwtUtil.generateToken(email);
            String redirectUrl = "http://localhost:5173/dashboard?token=" + token;
            System.out.println("Redirecting to: " + redirectUrl);

            getRedirectStrategy().sendRedirect(
            	    request,
            	    response,
            	    "http://localhost:5173/dashboard?token=" + token
            	);
           
         
        } catch (IOException e) {
            throw new RuntimeException("Error during OAuth success handling", e);
        } 
    }
}