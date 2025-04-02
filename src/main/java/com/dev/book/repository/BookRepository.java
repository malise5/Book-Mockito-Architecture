package com.dev.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.book.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // Custom query methods can be defined here if needed
    // For example:
    // List<Book> findByAuthor(String author);
    // List<Book> findByTitleContaining(String title);
    
}
