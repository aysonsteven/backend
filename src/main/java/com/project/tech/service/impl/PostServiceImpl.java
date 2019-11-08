package com.project.tech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.tech.dao.PostDao;
import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblPosts;
import com.project.tech.service.PostService;
import com.project.tech.service.TokenService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	@Autowired
	private TokenService tokenService;

	@Override
	public ApiResponse<List<TblPosts>> findAllPost(String token) {
		Boolean isActive = tokenService.checkLogin(token).getResult();
		ApiResponse<List<TblPosts>> response;
		if (isActive == true) {
			response = new ApiResponse<List<TblPosts>>(HttpStatus.OK.value(), HttpStatus.OK, postDao.findAll());
		} else {
			response = new ApiResponse<List<TblPosts>>(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, new ArrayList<>());
		}
		return response;
	}

	@Override
	public ApiResponse<List<TblPosts>> findPostByConfigId(int configId) {
		return null;
	}

}
