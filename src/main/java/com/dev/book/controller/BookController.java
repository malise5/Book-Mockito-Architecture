package com.dev.book.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.book.dto.BookDto;
import com.dev.book.service.BookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/v1/api")
public class BookController {

    // Inject the BookService
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable String isbn,@RequestBody BookDto bookDto) {
        BookDto createdBook = bookService.createBook(bookDto);
        // return ResponseEntity.ok(createdBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);

    }
    
}
