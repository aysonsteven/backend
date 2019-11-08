package com.project.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.tech.model.TblTokens;

@Repository
public interface TokenDao extends JpaRepository<TblTokens, Integer>{

//	TokenDto findByTokenName(@Param("tokenName") String tokenName);
	@Query(nativeQuery = true, value = "SELECT * FROM tbl_tokens  WHERE token = ?1")
	TblTokens findByToken(String tokenName);
}
