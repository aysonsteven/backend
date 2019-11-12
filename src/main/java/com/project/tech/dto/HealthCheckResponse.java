package com.project.tech.dto;

import java.util.ArrayList;
import java.util.List;

public class HealthCheckResponse<T> {

	String title = "";
	List<T> results = new ArrayList<T>();
	
	public HealthCheckResponse(String title, List<T> results) {
	}
}
