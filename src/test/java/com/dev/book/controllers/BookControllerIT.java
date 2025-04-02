package com.dev.book.controllers;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.dev.book.TestData.testBookDto;
import static com.dev.book.TestData.testBookEntity;

import javax.swing.Spring;

import com.dev.book.dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class BookControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testThatBookIsCreated() throws Exception{
        final BookDto bookDto = testBookDto();
        final ObjectMapper objectMapper = new ObjectMapper();
        final String bookJson = objectMapper.writeValueAsString(bookDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/api/books/" + bookDto.getIsbn())
                .contentType("application/json")
                .content(bookJson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.isbn").value(bookDto.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(bookDto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value(bookDto.getAuthor()))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    
}
