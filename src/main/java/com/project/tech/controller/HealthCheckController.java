package com.project.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tech.service.TokenService;
import com.project.tech.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class HealthCheckController {
	
	@Autowired
	private UserService userService;
	
	@Autowired TokenService tokenService;
	
	@GetMapping("healthcheck")
	public String check() {
		return "healthCheck";
	}
	
	@GetMapping("testUser")
	public Object testuser() {
		return userService.findAll();
	}
}
