package com.dev.book.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.book.dto.BookDto;
import com.dev.book.entity.Book;
import com.dev.book.repository.BookRepository;
import com.dev.book.service.BookService;

@Service
public class BookImp implements BookService {

    private final BookRepository bookRepository;

    public BookImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public Optional<BookDto> getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        return book.map(books -> convertToDto(books));
    }

    @Override
    public BookDto createBook(BookDto book) {
        Book bookEntity = convertToEntity(book);
        Book savedBook = bookRepository.save(bookEntity);
        return convertToDto(savedBook);

    }

    private Book convertToEntity(BookDto bookDto) {
        Book book = Book.builder()
                .isbn(bookDto.getIsbn())
                .author(bookDto.getAuthor())
                .title(bookDto.getTitle())
                .build();
        return book;
    }
    private BookDto convertToDto(Book book) {
        BookDto bookDto = BookDto.builder()
                .isbn(book.getIsbn())
                .author(book.getAuthor())
                .title(book.getTitle())
                .build();
        return bookDto;
    }


   

   
    
}
