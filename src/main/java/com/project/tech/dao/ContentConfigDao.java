package com.project.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.tech.model.TblContentConfig;

@Repository
public interface ContentConfigDao extends JpaRepository<TblContentConfig, Integer> {

}
