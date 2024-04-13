package com.example.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {
	
	//find password and role by email
	User findByEmail(String email);

}
