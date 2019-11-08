package com.project.tech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.project.tech.dao.PostDao;
import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblPosts;
import com.project.tech.service.PostService;

public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public ApiResponse<List<TblPosts>> findAllPost() {
		return new ApiResponse<List<TblPosts>>(HttpStatus.OK.value(), HttpStatus.OK, postDao.findAll());
	}

}
