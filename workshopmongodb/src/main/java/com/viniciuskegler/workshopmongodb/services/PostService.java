package com.viniciuskegler.workshopmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciuskegler.workshopmongodb.domain.Post;
import com.viniciuskegler.workshopmongodb.repository.PostRepository;
import com.viniciuskegler.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public Post findById(String id){
		Optional<Post> obj = postRepo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found."));
	}
	
}
