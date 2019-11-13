package com.project.tech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.tech.model.TblContent;

@Repository
public interface ContentDao extends JpaRepository<TblContent, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM tbl_content_prt WHERE content_conf_id = ?1")
	List<TblContent> findContentsByConfigId(Integer configId);

}
