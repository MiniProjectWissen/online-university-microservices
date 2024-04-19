package com.example.forum.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ForumMessageException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public ForumMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
