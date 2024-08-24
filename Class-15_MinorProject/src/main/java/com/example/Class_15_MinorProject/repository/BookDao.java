package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer> {
    // FindByAttr1(value)
    // Select * from book where attr1 = "value"

    List<Book> findByGenre(Genre genre);
    List<Book> findByName(String bookName);

    @Query("Select b from Book b, Author a where b.book_author.id = a.id and a.name = ?1")
    List<Book> findByAuthor_Name(String authorName);

}
