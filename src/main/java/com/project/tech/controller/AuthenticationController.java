package com.project.tech.controller;


import com.project.tech.dto.ApiResponse;
import com.project.tech.dto.AuthToken;
import com.project.tech.dto.LoginUser;
import com.project.tech.dto.TokenDto;
import com.project.tech.model.TblTokens;
import com.project.tech.model.TblUser;
import com.project.tech.service.TokenService;
import com.project.tech.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import jar.security.config.JwtTokenUtil;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired(required = false)
	private AuthenticationManager authenticationManager;

	@Autowired(required = false)
	private UserService userService;

	@Autowired(required = false)
	private TokenService tokenService;
	
	@GetMapping("/healthcheck")
	public String healthcheck() {
		return "success";
	}

	@PostMapping("/login")
	public ApiResponse<AuthToken> login(@RequestBody LoginUser loginUser) throws AuthenticationException {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		return userService.login(loginUser);
	}
	
	@PostMapping("/logout")
	public ApiResponse<String> logout(@RequestHeader(value="Authorization") String token){
		return userService.logout(token);
	}
	
	@GetMapping("/checklogin")
	public ApiResponse<Boolean> checklogin( @RequestHeader(value="Authorization") String token){
		return tokenService.checkLogin(token);
	}

}
