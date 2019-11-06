package com.dynamic.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.tech.model.TblTokens;

@Repository
public interface TokenDao extends JpaRepository<TblTokens, Integer>{

//	TokenDto findByTokenName(@Param("tokenName") String tokenName);
	TblTokens findByToken(String tokenName);
}
