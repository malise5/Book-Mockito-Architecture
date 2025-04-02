package com.dev.book;

import com.dev.book.dto.BookDto;
import com.dev.book.entity.Book;

public final class TestData {

    private TestData() {
        // Prevent instantiation
    }

    // Test data for BookDto
    public static BookDto testBookDto() {
        return BookDto.builder()
                .isbn(BOOK_ISBN)
                .author(BOOK_AUTHOR)
                .title(BOOK_TITLE)
                .build();
    }
    public static Book testBookEntity() {
        return Book.builder()
                .isbn(BOOK_ISBN)
                .author(BOOK_AUTHOR)
                .title(BOOK_TITLE)
                .build();
    }
    
    public static final String BOOK_ISBN = "978-3-16-148410-0";
    public static final String BOOK_AUTHOR = "John Doe";
    public static final String BOOK_TITLE = "Sample Book Title";

    public static final String BOOK_ISBN_2 = "978-1-23-456789-0";
    public static final String BOOK_AUTHOR_2 = "Jane Smith";
    public static final String BOOK_TITLE_2 = "Another Sample Book Title";

    // Add more test data as needed
}
