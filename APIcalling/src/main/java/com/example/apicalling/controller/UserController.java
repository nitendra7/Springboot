package com.example.apicalling.controller;

import com.example.apicalling.model.UserModel;
import com.example.apicalling.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add-request")
    public UserModel addRequest(@RequestBody UserModel userModel) {
        return service.addRequest(userModel);
    }
}
