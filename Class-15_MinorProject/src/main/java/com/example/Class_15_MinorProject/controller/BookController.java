package com.example.Class_15_MinorProject.controller;

import com.example.Class_15_MinorProject.dto.CreateAdminRequest;
import com.example.Class_15_MinorProject.dto.CreateBookRequest;
import com.example.Class_15_MinorProject.dto.GetBookResponse;
import com.example.Class_15_MinorProject.dto.SearchRequest;
import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        // create admin

        bookService.createOrUpdateBook(createBookRequest.to());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Book got added successfully");

    }

    @GetMapping("/search")
    // TODO - convert into dto
    public List<Book> getBooks(@RequestBody @Valid SearchRequest searchRequest) {
        try {
            return bookService.findBook(searchRequest.getSearchKey(), searchRequest.getSearchValue());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    // TODO - delete a book


}

// get book based on some genre

// get book by an author

// book by id

// book by name
