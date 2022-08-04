package com.viniciuskegler.workshopmongodb.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniciuskegler.workshopmongodb.domain.User;
import com.viniciuskegler.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepo.saveAll(List.of(maria,alex,bob));
	}

}
