package com.example.forum.controller;

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

import com.example.forum.dao.ForumDao;
import com.example.forum.entity.Forum;


@RestController
public class ForumController {
	
	@Autowired
	private ForumDao forumDao;
	
	@PostMapping("forum/send")
    public ResponseEntity<Object> sendMessage(@RequestBody Forum msg) {
        
		if (msg == null || msg.getMessage() == null || msg.getMessage().isEmpty()) {
            return new ResponseEntity<>("Message body cannot be empty", HttpStatus.BAD_REQUEST);
        }
		
        try {
            Forum savedMsg = forumDao.save(msg);
            return ResponseEntity.ok(savedMsg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while sending the message.");
        }
    }
    
    @GetMapping("forum/receive/{forumId}")
    public ResponseEntity<Object> receiveMessage(@PathVariable int forumId) {
        try {
            List<Forum> messageList = forumDao.findByForumIdOrderByTimestamp(forumId);
            return ResponseEntity.ok(messageList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while receiving messages.");
        }
    }

}
