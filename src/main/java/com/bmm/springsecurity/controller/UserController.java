package com.bmm.springsecurity.controller;


import com.bmm.springsecurity.model.User;
import com.bmm.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

 @Autowired
 private UserService service;


    @PostMapping("/request")
    public User request(@RequestBody User user){
        return service.request(user);
    }
}
