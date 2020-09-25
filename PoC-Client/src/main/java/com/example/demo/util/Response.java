package com.example.demo.util;

import org.springframework.http.HttpStatus;

public class Response {
	private Object result;
	private String message;
	private HttpStatus status;

	@Override
	public String toString() {
		return "Response [result=" + result + ", message=" + message + ", status=" + status + "]";
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
