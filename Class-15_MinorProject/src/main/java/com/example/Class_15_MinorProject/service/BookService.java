package com.example.Class_15_MinorProject.service;

import com.example.Class_15_MinorProject.models.Author;
import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Genre;
import com.example.Class_15_MinorProject.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookDao bookDao;

    public void createOrUpdateBook(Book book) {
        // Get or create the author using author details
        Author bookAuthor = authorService.getOrCreate(book.getAuthor());

        // set the author
        book.setAuthor(bookAuthor);

        // Save the book
        bookDao.save(book);
    }

    public List<Book> findBook(String searchKey, String searchValue) throws Exception {
        return switch (searchKey) {
            case "genre" -> bookDao.findByGenre(Genre.valueOf(searchValue));
            case "name" -> bookDao.findByName(searchValue);
            case "author_name" -> bookDao.findByAuthor_Name(searchValue);
            case "id" -> {
                Optional<Book> book = bookDao.findById(Integer.parseInt(searchValue));
                yield book.map(List::of).orElseGet(ArrayList::new);
            }
            default -> throw new Exception("Invalid search key: " + searchKey);
        };
    }
}
