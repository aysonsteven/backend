package com.project.tech.service;

import com.project.tech.dto.ApiResponse;
import com.project.tech.dto.AuthToken;
import com.project.tech.dto.LoginUser;
import com.project.tech.dto.UserDto;
import com.project.tech.model.TblUser;

import java.util.List;

public interface UserService {

    TblUser save(UserDto user);
    List<TblUser> findAll();
    void delete(int id);

    TblUser findOne(String username);

    TblUser findById(int id);

    UserDto update(UserDto userDto);
    
    ApiResponse<AuthToken> login(LoginUser loginUser);
}
