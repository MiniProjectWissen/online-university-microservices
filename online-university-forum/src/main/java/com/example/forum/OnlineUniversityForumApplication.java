package com.example.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnlineUniversityForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineUniversityForumApplication.class, args);
	}

}
