package com.example.forum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.forum.entity.Forum;

@Repository
public interface ForumDao extends JpaRepository<Forum, Integer> {

	@Query("SELECT f FROM Forum f WHERE f.forum_id = :forumId ORDER BY f.timestamp")
    List<Forum> findByForumIdOrderByTimestamp(@Param("forumId") int forumId);
}
