package com.dev.book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import static com.dev.book.TestData.testBookDto;
import static com.dev.book.TestData.testBookEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.book.dto.BookDto;
import com.dev.book.entity.Book;
import com.dev.book.repository.BookRepository;
import com.dev.book.service.impl.BookImp;

@ExtendWith(MockitoExtension.class)
public class BookImpTests {
    
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookImp underTest;

    @Test
    public void testGetAllBooks(){
        // Mock the behavior of the bookRepository
        when(bookRepository.findAll()).thenReturn(List.of(testBookEntity()));

        // Call the method to be tested
        final List<BookDto> books = underTest.getAllBooks();

        // Verify the interaction with the repository
        assertEquals(1, books.size());
        assertEquals(testBookDto().getIsbn(), books.get(0).getIsbn());
    }

    @Test
    public void testFindBookByIsbnReturnsEmptyWhenNoBook(){
        final String bookDto = "123456987";

        // Mock the behavior of the bookRepository
        when(bookRepository.findById(eq(bookDto))).thenReturn(Optional.empty());

        // Call the method to be tested
        final Optional<BookDto> foundBook = underTest.getBookByIsbn(bookDto);

        // Verify the interaction with the repository
        assertEquals(Optional.empty(), foundBook);
    }

    @Test
    public void testFindBookByIsbnReturnsBookWhenExists(){
        BookDto bookDto = testBookDto();
        Book bookEntity = testBookEntity();

        // Mock the behavior of the bookRepository
        when(bookRepository.findById(eq(bookDto.getIsbn()))).thenReturn(Optional.of(bookEntity));

        // Call the method to be tested
        final Optional<BookDto> foundBook = underTest.getBookByIsbn(bookDto.getIsbn());

        // Verify the interaction with the repository
        assertEquals(Optional.of(bookDto), foundBook);
    }



    @Test
    public void testCreateBook(){
        BookDto bookDto = testBookDto();
        Book bookEntity = testBookEntity();
        
        // Mock the behavior of the bookRepository
        when(bookRepository.save(any(Book.class))).thenReturn(bookEntity);
        // when(bookRepository.save(eq(bookEntity))).thenReturn(bookEntity);

        // Call the method to be tested
        final BookDto createdBook = underTest.createBook(bookDto);

        // Verify the interaction with the repository
        // assertEquals(bookEntity, createdBook);

        assertEquals(bookDto.getIsbn(), createdBook.getIsbn());
        assertEquals(bookDto.getAuthor(), createdBook.getAuthor());
        assertEquals(bookDto.getTitle(), createdBook.getTitle());
    }
}
