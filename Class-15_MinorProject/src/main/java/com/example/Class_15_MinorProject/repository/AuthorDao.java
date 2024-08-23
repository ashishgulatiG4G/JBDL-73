package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);

}
