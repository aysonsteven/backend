package com.project.tech.service;

import java.util.List;

import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblPosts;

public interface PostService {
	
	ApiResponse<List<TblPosts>> findAllPost();

}
