package com.example.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<Object> handleException(InvalidUserException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
}
