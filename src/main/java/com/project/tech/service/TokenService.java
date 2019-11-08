package com.project.tech.service;

import com.project.tech.dto.ApiResponse;
import com.project.tech.dto.TokenDto;

import com.project.tech.model.TblTokens;

public interface TokenService {
	ApiResponse<String> inserTokens(TokenDto token, int uid);

	TblTokens findTokenByName(String token);
	
	String deleteTokenByTokenName(String token);
	
	ApiResponse<Boolean> checkLogin(String token);
	
	
}
