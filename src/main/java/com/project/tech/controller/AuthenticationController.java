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
	private JwtTokenUtil jwtTokenUtil;

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
		final TblUser user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user.getUsername());
		TokenDto tokenObject = new TokenDto();
		tokenObject.setToken(token);
		return new ApiResponse<>(HttpStatus.OK.value(), tokenService.inserTokens(tokenObject, user.getId()),
				new AuthToken(token, loginUser.getUsername()));
	}
	
	@DeleteMapping("/logout")
	public ApiResponse<String> logout(@RequestHeader(value="Authorization") String token){
		String tokenObject = tokenService.deleteTokenByTokenName(token.replaceAll("Bearer ", ""));
		return new ApiResponse<>(HttpStatus.OK.value(), "deleted", tokenObject);
	}
	
	@GetMapping("/checklogin")
	public ApiResponse<Boolean> checklogin( @RequestHeader(value="Authorization") String token){
		TblTokens tokenObject = tokenService.findTokenByName( token.replaceAll("Bearer ", ""));
		Boolean isTokenValid = false;
		if( tokenObject != null ) {
			isTokenValid = true;
		}
		return new ApiResponse<>(HttpStatus.OK.value(), "Login Status", isTokenValid);
	}

}