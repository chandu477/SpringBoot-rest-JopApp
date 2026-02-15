package com.example.SpringBoot_rest_JopApp.service;


import com.example.SpringBoot_rest_JopApp.model.User;
import com.example.SpringBoot_rest_JopApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("the password is" +encoder.encode(user.getPassword()));
       return userRepository.save(user);
    }
}
