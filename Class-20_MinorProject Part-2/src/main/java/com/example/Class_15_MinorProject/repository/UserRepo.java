package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByUsername(String name);

}
