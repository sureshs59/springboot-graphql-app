package com.example.springboot.graphql.service;

import com.example.springboot.graphql.entity.Book;
import com.example.springboot.graphql.repository.BookRepository;
import com.example.springboot.graphql.repository.AuthorRepository;
import com.example.springboot.graphql.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertNotNull(books);
    }
}
