package com.example.apicalling.service;

import com.example.apicalling.model.UserModel;
import com.example.apicalling.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceApi implements UserService {

    private final UserRepository repository;

    public UserServiceApi(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserModel addRequest(UserModel userModel) {
        String response = "This is the response from Gemini";
        userModel.setResponse(response);
        repository.save(userModel);
        return userModel;
    }
}
