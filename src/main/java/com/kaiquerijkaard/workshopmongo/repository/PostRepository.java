package com.kaiquerijkaard.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaiquerijkaard.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
}
