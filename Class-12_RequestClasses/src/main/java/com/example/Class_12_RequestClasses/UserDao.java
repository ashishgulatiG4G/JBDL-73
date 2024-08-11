package com.example.Class_12_RequestClasses;

import com.example.Class_12_RequestClasses.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDao {

    public boolean registerUser(User user) {
        log.info(String.valueOf(user));
        return user.getUsername().equals("123");
    }



}
