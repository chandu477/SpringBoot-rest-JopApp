package com.example.SpringBoot_rest_JopApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider(userDetailsService);

        // ✅ Correct method name
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        daoAuthenticationProvider.setPasswordEncoder(
                new BCryptPasswordEncoder(12)
        );

        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity){
        //using Lambda
        httpSecurity.csrf(customizer -> customizer.disable()); //this disable csrf
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated()); //enable security fro all request
//        httpSecurity.formLogin(Customizer.withDefaults()); //get default login form
        httpSecurity.httpBasic(Customizer.withDefaults()); //use of postman
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //stateless
        //if we make everything stateless then we dont need login of form  (remove line 20)
        //for update and delete we don't have to pass the csrf token if we use stateless


        //Without Lambda
        //we can use it video no :148

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                                      .username("newchandan")
//                                      .password("123")
//                                      .roles("user")
//                                      .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("newadmin")
//                .password("12345")
//                .roles("admin")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }
}
