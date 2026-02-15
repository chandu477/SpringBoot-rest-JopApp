package com.example.SpringBoot_rest_JopApp.service;

import com.example.SpringBoot_rest_JopApp.model.User;
import com.example.SpringBoot_rest_JopApp.model.UserPrinciple;
import com.example.SpringBoot_rest_JopApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found in db");
        }
        return new UserPrinciple(user);
    }
}
