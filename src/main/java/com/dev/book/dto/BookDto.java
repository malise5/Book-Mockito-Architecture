package com.dev.book.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @Id
    private String isbn;
    private String author;
    private String title;

    // Add any other fields or methods as needed
}
