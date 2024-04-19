package com.example.forum.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.forum.dao.MessageDao;

import com.example.forum.entity.Message;
import com.example.forum.exception.ForumMessageException;


@RestController
@CrossOrigin("http://localhost:4200")
public class MessageController {
	
	@Autowired
	private MessageDao messageDao;
	
	@PostMapping("forum/send")
    public ResponseEntity<Object> sendMessage(@RequestBody Message msg) {
        
		if (msg == null || msg.getMessage() == null || msg.getMessage().isEmpty()) {
            return new ResponseEntity<>("Message body cannot be empty", HttpStatus.BAD_REQUEST);
        }
		
        try {
            Message savedMsg = messageDao.save(msg);
            return ResponseEntity.ok(savedMsg);
        } catch (Exception e) {
        	throw new ForumMessageException("An error occurred while sending messages.", e);
        }
    }
    
    @GetMapping("forum/receive/{forumId}")
    public ResponseEntity<List<Message>> receiveMessage(@PathVariable int forumId) {
        try {
            List<Message> messageList = messageDao.findByForumIdOrderByTimestamp(forumId);
            return ResponseEntity.ok(messageList);
        } catch (Exception e) {
        	throw new ForumMessageException("An error occurred while receiving messages.", e);
        }
    }

}
