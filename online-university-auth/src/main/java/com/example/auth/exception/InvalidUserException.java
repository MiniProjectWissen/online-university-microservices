package com.example.auth.exception;

public class InvalidUserException extends RuntimeException{

	private static final long serialVersionUID = -2016176758243219649L;

	public InvalidUserException() {
		super();
	}

	public InvalidUserException(String message) {
		super(message);
	}
}

