package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Author;
import com.example.Class_15_MinorProject.repository.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    public Author getOrCreate(Author author) {

        // try to get the author with the same email
        Author existingAuthor = authorDao.findByEmail(author.getEmail());

        // if it doesn't -> create the author and return the same
        if(existingAuthor == null) {
            existingAuthor = authorDao.save(author);
        }

        // if it exists -> return the author object
        return existingAuthor;

    }



}
