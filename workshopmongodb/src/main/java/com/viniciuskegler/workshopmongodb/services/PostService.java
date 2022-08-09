package com.viniciuskegler.workshopmongodb.services;

import java.util.Date;
import java.util.List;
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

	public Post findById(String id) {
		Optional<Post> obj = postRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}

	public List<Post> findByTitle(String text) {
		return postRepo.findByTitleContainingIgnoreCase(text);
	}

	public List<Post> searchBetween(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepo.searchBetween(text, minDate, maxDate);
	}

}
