package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class CustomExceptionHandlerEx {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response methodArgumentexceptionHandlerMethod(MethodArgumentNotValidException e) {
		Response response = new Response();
		response.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
		// response.setStatus("400");
		return response;
	}

}
