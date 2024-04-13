package com.example.forum.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Forum {

	public Forum() {
		
	}
	
	
	@jakarta.persistence.Id
	private int forum_id;
	private int user_id;
	private int first_name;
	private String message;
	private Timestamp timestamp;
	
	
	
	public Forum(int forum_id, int user_id, int first_name, String message, Timestamp timestamp) {
		super();
		this.forum_id = forum_id;
		this.user_id = user_id;
		this.first_name = first_name;
		this.message = message;
		this.timestamp = timestamp;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getFirst_name() {
		return first_name;
	}
	public void setFirst_name(int first_name) {
		this.first_name = first_name;
	}

	
	
}
