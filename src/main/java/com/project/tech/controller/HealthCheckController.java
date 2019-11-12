package com.project.tech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tech.dto.ApiResponse;
import com.project.tech.dto.HealthCheckResponse;
import com.project.tech.service.TokenService;
import com.project.tech.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class HealthCheckController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private TokenService tokenService;
	
	@GetMapping
	public String main() {
		return "main";
	}
	
	@GetMapping("healthcheck")
	public String check() {
		return "healthCheck";
	}
	
	
	@GetMapping("testUser")
	public Object testuser() {
		return userService.findAll();
	}
}
