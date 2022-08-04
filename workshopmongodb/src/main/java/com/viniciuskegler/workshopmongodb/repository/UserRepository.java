package com.viniciuskegler.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciuskegler.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
