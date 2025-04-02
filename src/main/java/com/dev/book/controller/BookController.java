package com.dev.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.book.dto.BookDto;
import com.dev.book.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/v1/api")
public class BookController {

    // Inject the BookService
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Endpoint to get all books
    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    // Endpoint to get a book by ISBN
    @GetMapping("/books/{isbn}")
    public ResponseEntity<Optional<BookDto>> getBookByIsbn(@PathVariable String isbn) {
        Optional<BookDto> book = bookService.getBookByIsbn(isbn);
        if (book.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable String isbn,@RequestBody BookDto bookDto) {
        BookDto createdBook = bookService.createBook(bookDto);
        // return ResponseEntity.ok(createdBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);

    }
    
}
