package com.project.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.tech.model.TblPosts;

@Repository
public interface PostDao extends JpaRepository<TblPosts, Integer> {

}
