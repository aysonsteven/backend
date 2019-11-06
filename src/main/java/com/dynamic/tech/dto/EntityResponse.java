package com.dynamic.tech.dto;

import org.springframework.http.HttpStatus;

public class EntityResponse<T> {
	
	private Integer statusCode;
	
	private HttpStatus message;
	
	private T result;
	
	public EntityResponse(Integer statusCode, HttpStatus message, T result) {
		this.statusCode = statusCode;
		this.message = message;
		this.result = result;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public HttpStatus getMessage() {
		return message;
	}

	public void setMessage(HttpStatus message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
