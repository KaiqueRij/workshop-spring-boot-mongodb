package com.kaiquerijkaard.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiquerijkaard.workshopmongo.domain.User;
import com.kaiquerijkaard.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
}
