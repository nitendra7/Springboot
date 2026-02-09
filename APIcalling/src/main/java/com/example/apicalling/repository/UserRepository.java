package com.example.apicalling.repository;

import com.example.apicalling.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel,String> {

}
