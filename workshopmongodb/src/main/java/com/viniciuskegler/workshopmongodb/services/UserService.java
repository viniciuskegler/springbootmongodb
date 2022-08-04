package com.viniciuskegler.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuskegler.workshopmongodb.domain.User;
import com.viniciuskegler.workshopmongodb.dto.UserDTO;
import com.viniciuskegler.workshopmongodb.repository.UserRepository;
import com.viniciuskegler.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll(){
		return userRepo.findAll();
	}

	public User findById(String id){
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found."));
	}
	
	public User insert(User obj) {
		return userRepo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		userRepo.deleteById(id);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
