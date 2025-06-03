package com.bmm.springsecurity.service;


import com.bmm.springsecurity.model.User;
import com.bmm.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User request(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
