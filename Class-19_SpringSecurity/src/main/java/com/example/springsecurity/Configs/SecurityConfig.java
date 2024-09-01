package com.example.springsecurity.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService inMemoryUserDetailsService() {
//        UserDetails user1 = User.builder()
//                .username("ashish")
//                .password(passwordEncoder().encode("1234"))
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("1234"))
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    public UserDetailsService userInfoService() {
        return new UserInfoService();
    }

}



