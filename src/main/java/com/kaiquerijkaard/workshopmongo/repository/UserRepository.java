package com.kaiquerijkaard.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kaiquerijkaard.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
}
