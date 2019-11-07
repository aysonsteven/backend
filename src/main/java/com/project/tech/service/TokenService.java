package com.project.tech.service;

import com.project.tech.dto.TokenDto;

import com.project.tech.model.TblTokens;

public interface TokenService {
	String inserTokens(TokenDto token, int uid);

	TblTokens findTokenByName(String token);
	
	String deleteTokenByTokenName(String token);
	
	
}
