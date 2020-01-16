package com.kaiquerijkaard.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiquerijkaard.workshopmongo.domain.User;
import com.kaiquerijkaard.workshopmongo.dto.UserDTO;
import com.kaiquerijkaard.workshopmongo.repository.UserRepository;
import com.kaiquerijkaard.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return this.userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return this.userRepository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		this.userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = this.findById(obj.getId());
		updateData(newObj, obj);
		return this.userRepository.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
