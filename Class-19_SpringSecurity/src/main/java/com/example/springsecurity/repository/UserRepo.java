package com.example.springsecurity.repository;

import com.example.springsecurity.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);

}
