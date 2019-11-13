package com.project.tech.service;

import java.util.List;

import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblContent;
import com.project.tech.model.TblContentConfig;

public interface ContentService {
	
	ApiResponse<List<TblContentConfig>> getAllContentConfig();
	
	ApiResponse<TblContentConfig> getContentConfig();
	
	ApiResponse<List<TblContent>> getAllContent();
	
	ApiResponse<List<TblContent>> getContentsByConfigId(Integer configId);
}
