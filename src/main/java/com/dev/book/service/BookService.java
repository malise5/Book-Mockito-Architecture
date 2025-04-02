package com.dev.book.service;

import java.util.List;
import java.util.Optional;

import com.dev.book.dto.BookDto;

public interface BookService {
    List<BookDto> getAllBooks();
    BookDto createBook(BookDto book);
    Optional<BookDto> getBookByIsbn(String isbn);
    // Book getBookByIsbn(String isbn);
    // void deleteBook(String isbn);
    // void updateBook(String isbn, Book book);
} 