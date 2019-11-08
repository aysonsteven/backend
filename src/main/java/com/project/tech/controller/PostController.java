package com.project.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblPosts;
import com.project.tech.service.PostService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("posttest")
	public String postTest() {
		return "post";
	}
	
	@GetMapping("getAllPosts")
	public ApiResponse<List<TblPosts>> getAllPosts(@RequestHeader(value="Authorization") String token){
		return postService.findAllPost(token);
	}
}
