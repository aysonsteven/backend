package com.project.tech.dto;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    private int status;
    private HttpStatus message;
    private T result;

    public ApiResponse(int status, HttpStatus message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
