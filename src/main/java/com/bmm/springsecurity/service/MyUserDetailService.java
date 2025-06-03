package com.bmm.springsecurity.service;


import com.bmm.springsecurity.model.User;
import com.bmm.springsecurity.model.UserPrinciple;
import com.bmm.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

     @Autowired
     private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user=repo.findByUsername(username);

        if(user==null){
            System.out.printf("Username %s not found",username);
            throw new UsernameNotFoundException("User not found");

        }



        return new UserPrinciple(user);
    }

}
