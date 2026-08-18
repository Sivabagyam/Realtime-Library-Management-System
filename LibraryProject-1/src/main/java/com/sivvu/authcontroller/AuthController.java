package com.sivvu.authcontroller;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivvu.dto.LoginRequest;
import com.sivvu.security.JwtService;
@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	public AuthController(AuthenticationManager authenticationManager,JwtService jwtService) {
		this.authenticationManager=authenticationManager;
		this.jwtService=jwtService;
		
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		return jwtService.generateToken(authentication.getName());		
				
	}

}
