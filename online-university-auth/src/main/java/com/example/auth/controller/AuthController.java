package com.example.auth.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.User;
import com.example.auth.exception.InvalidUserException;
import com.example.auth.serviceImpl.AuthServiceImpl;




@RestController
@CrossOrigin("http://localhost:4200")
public class AuthController {

	@Autowired
	AuthServiceImpl authService;
	
	@PostMapping("/auth")
	public ResponseEntity<Object> auth(@RequestBody User a)
	{
		Boolean b= authService.authenticate(a);
		if (b==true) return new ResponseEntity<>(Collections.singletonMap("msg","Authenticated successfully"), HttpStatus.OK);
		else throw new InvalidUserException("Auth failed");
	}
	
	@PostMapping("/auth/add")
	public ResponseEntity<Object> addUser(@RequestBody User a)
	{
		try {
			authService.addUser(a);

			return new ResponseEntity<>(Collections.singletonMap("msg","User added successfully"), HttpStatus.OK);

			
		} catch (InvalidUserException e) {

			throw  new InvalidUserException(e.getMessage()+"error while adding user in db");

		}
	}
	
	@DeleteMapping("/auth/{userId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable String userId)
	{
		try {
			authService.deleteUserByEmailId(userId);
			return new ResponseEntity<>(Collections.singletonMap("msg","Student deleted successfully"), HttpStatus.OK);
		}catch (InvalidUserException e) {
			throw  new InvalidUserException(e.getMessage()+"Stud Id error");
		}

	}
}
