package com.project.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblContent;
import com.project.tech.model.TblContentConfig;
import com.project.tech.service.ContentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@GetMapping("/getallconfig")
	private ApiResponse<List<TblContentConfig>> getAll(){
		return contentService.getAllContentConfig();
	}
	
	@GetMapping("/getallcontent")
	private ApiResponse<List<TblContent>> getAllContent(){
		return contentService.getAllContent();
	}
	
	@GetMapping("/contentbyconfigid/{pagemodule}")
	private ApiResponse<List<TblContent>> getContentsByConfigId(@PathVariable("pagemodule") Integer page){
		System.out.println("PATHVAR" + page);
		return contentService.getContentsByConfigId(page);
	}

}
