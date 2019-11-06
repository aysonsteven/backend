package com.dynamic.tech.service;

import com.dynamic.tech.dto.TokenDto;

import com.dynamic.tech.model.TblTokens;

public interface TokenService {
	String inserTokens(TokenDto token, int uid);

	TblTokens findTokenByName(String token);
	
	String deleteTokenByTokenName(String token);
	
	
}
