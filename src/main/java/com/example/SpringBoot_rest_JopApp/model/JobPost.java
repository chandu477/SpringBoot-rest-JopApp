package com.example.SpringBoot_rest_JopApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


//here we can avoid using getter and setter because we can use lombok
//we have added lombok in our dependency
//we can directly use annotation @Data,

@Data
//will get the default constructor  and add all the parameters in the constructor .
@NoArgsConstructor
@AllArgsConstructor
//as we are going to use it in springboot so we need declare it as component
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;
}
