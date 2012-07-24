package net.baguajie.repositories;

import net.baguajie.domains.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepository extends 
		AtomicOperationsRepository<Comment, String> {
	
	@Query("{ 'act': {'$ref': 'activity', '$id': { '$oid': ?0 } }}")
	Page<Comment> findByAct(String id, Pageable pageable);
	
}