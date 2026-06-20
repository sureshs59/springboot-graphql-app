package com.example.springboot.graphql.controller;

import com.example.springboot.graphql.entity.Author;
import com.example.springboot.graphql.entity.Book;
import com.example.springboot.graphql.entity.Publisher;
import com.example.springboot.graphql.input.CreateAuthorInput;
import com.example.springboot.graphql.input.CreateBookInput;
import com.example.springboot.graphql.input.CreatePublisherInput;
import com.example.springboot.graphql.input.UpdateAuthorInput;
import com.example.springboot.graphql.input.UpdateBookInput;
import com.example.springboot.graphql.input.UpdatePublisherInput;
import com.example.springboot.graphql.repository.BookRepository;
import com.example.springboot.graphql.service.AuthorService;
import com.example.springboot.graphql.service.BookService;
import com.example.springboot.graphql.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * GraphQL Query and Mutation Controller
 */
@Controller
public class GraphQLController {

    private static final Logger logger = LoggerFactory.getLogger(GraphQLController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookRepository bookRepository;

    // ==================== Book Queries ====================

    @QueryMapping
    public List<Book> books() {
        logger.info("Query: Fetching all books");
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument Long id) {
        logger.info("Query: Fetching book by ID: {}", id);
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> booksByAuthor(@Argument Long authorId) {
        logger.info("Query: Fetching books by author ID: {}", authorId);
        return bookService.getBooksByAuthor(authorId);
    }

    @QueryMapping
    public List<Book> searchBooks(@Argument String title) {
        logger.info("Query: Searching books by title: {}", title);
        return bookService.searchBooksByTitle(title);
    }

    // ==================== Author Queries ====================

    @QueryMapping
    public List<Author> authors() {
        logger.info("Query: Fetching all authors");
        return authorService.getAllAuthors();
    }

    @QueryMapping
    public Author authorById(@Argument Long id) {
        logger.info("Query: Fetching author by ID: {}", id);
        return authorService.getAuthorById(id);
    }

    @QueryMapping
    public Author authorByName(@Argument String name) {
        logger.info("Query: Fetching author by name: {}", name);
        return authorService.getAuthorByName(name);
    }

    // ==================== Publisher Queries ====================

    @QueryMapping
    public List<Publisher> publishers() {
        logger.info("Query: Fetching all publishers");
        return publisherService.getAllPublishers();
    }

    @QueryMapping
    public Publisher publisherById(@Argument Long id) {
        logger.info("Query: Fetching publisher by ID: {}", id);
        return publisherService.getPublisherById(id);
    }

    // ==================== Book Mutations ====================

    @MutationMapping
    public Book createBook(@Argument CreateBookInput input) {
        logger.info("Mutation: Creating book: {}", input.getTitle());
        return bookService.createBook(
                input.getTitle(),
                input.getIsbn(),
                input.getPageCount(),
                input.getPublishedYear(),
                input.getDescription(),
                input.getPrice(),
                input.getAuthorId(),
                input.getPublisherId()
        );
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument UpdateBookInput input) {
        logger.info("Mutation: Updating book: {}", id);
        return bookService.updateBook(
                id,
                input.getTitle(),
                input.getIsbn(),
                input.getPageCount(),
                input.getPublishedYear(),
                input.getDescription(),
                input.getPrice()
        );
    }

    @MutationMapping
    public boolean deleteBook(@Argument Long id) {
        logger.info("Mutation: Deleting book: {}", id);
        return bookService.deleteBook(id);
    }

    // ==================== Author Mutations ====================

    @MutationMapping
    public Author createAuthor(@Argument CreateAuthorInput input) {
        logger.info("Mutation: Creating author: {}", input.getName());
        return authorService.createAuthor(
                input.getName(),
                input.getEmail(),
                input.getCountry(),
                input.getBiography()
        );
    }

    @MutationMapping
    public Author updateAuthor(@Argument Long id, @Argument UpdateAuthorInput input) {
        logger.info("Mutation: Updating author: {}", id);
        return authorService.updateAuthor(
                id,
                input.getName(),
                input.getEmail(),
                input.getCountry(),
                input.getBiography()
        );
    }

    @MutationMapping
    public boolean deleteAuthor(@Argument Long id) {
        logger.info("Mutation: Deleting author: {}", id);
        return authorService.deleteAuthor(id);
    }

    // ==================== Publisher Mutations ====================

    @MutationMapping
    public Publisher createPublisher(@Argument CreatePublisherInput input) {
        logger.info("Mutation: Creating publisher: {}", input.getName());
        return publisherService.createPublisher(
                input.getName(),
                input.getCountry(),
                input.getEmail(),
                input.getPhone()
        );
    }

    @MutationMapping
    public Publisher updatePublisher(@Argument Long id, @Argument UpdatePublisherInput input) {
        logger.info("Mutation: Updating publisher: {}", id);
        return publisherService.updatePublisher(
                id,
                input.getName(),
                input.getCountry(),
                input.getEmail(),
                input.getPhone()
        );
    }

    @MutationMapping
    public boolean deletePublisher(@Argument Long id) {
        logger.info("Mutation: Deleting publisher: {}", id);
        return publisherService.deletePublisher(id);
    }

    // ==================== Schema Mapping ====================

    @SchemaMapping(typeName = "Book")
    public Author author(Book book) {
        return book.getAuthor();
    }

    @SchemaMapping(typeName = "Book")
    public Publisher publisher(Book book) {
        return book.getPublisher();
    }

    @SchemaMapping(typeName = "Book")
    public String createdAt(Book book) {
        return book.getCreatedAt().toString();
    }

    @SchemaMapping(typeName = "Book")
    public String updatedAt(Book book) {
        return book.getUpdatedAt().toString();
    }

    @SchemaMapping(typeName = "Author")
    public String createdAt(Author author) {
        return author.getCreatedAt().toString();
    }

    @SchemaMapping(typeName = "Author")
    public String updatedAt(Author author) {
        return author.getUpdatedAt().toString();
    }

    @SchemaMapping(typeName = "Publisher")
    public String createdAt(Publisher publisher) {
        return publisher.getCreatedAt().toString();
    }

    @SchemaMapping(typeName = "Publisher")
    public String updatedAt(Publisher publisher) {
        return publisher.getUpdatedAt().toString();
    }
}
