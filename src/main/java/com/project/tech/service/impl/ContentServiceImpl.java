package com.project.tech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.tech.dao.ContentConfigDao;
import com.project.tech.dao.ContentDao;
import com.project.tech.dto.ApiResponse;
import com.project.tech.model.TblContent;
import com.project.tech.model.TblContentConfig;
import com.project.tech.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentConfigDao contentConfigDao;

	@Autowired
	private ContentDao contentDao;

	@Override
	public ApiResponse<List<TblContentConfig>> getAllContentConfig() {
		List<TblContentConfig> configList = contentConfigDao.findAll();
		return new ApiResponse<List<TblContentConfig>>(HttpStatus.OK.value(), HttpStatus.OK, configList);
	}

	@Override
	public ApiResponse<TblContentConfig> getContentConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse<List<TblContent>> getAllContent() {
		List<TblContent> contentList = contentDao.findAll();
		return new ApiResponse<List<TblContent>>(HttpStatus.OK.value(), HttpStatus.OK, contentList);
	}

	@Override
	public ApiResponse<List<TblContent>> getContentsByConfigId(Integer configId) {
		List<TblContent> contentList = contentDao.findContentsByConfigId(configId);
		return new ApiResponse<List<TblContent>>(HttpStatus.OK.value(), HttpStatus.OK, contentList);
	}

}
