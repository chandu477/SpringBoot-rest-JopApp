package com.example.SpringBoot_rest_JopApp.repository;


import com.example.SpringBoot_rest_JopApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUsername(String username);
}
