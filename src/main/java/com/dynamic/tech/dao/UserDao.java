package com.dynamic.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.tech.model.TblUser;

@Repository
public interface UserDao extends JpaRepository<TblUser, Integer> {

    TblUser findByUsername(String username);
    
    TblUser findById( int id );
}
