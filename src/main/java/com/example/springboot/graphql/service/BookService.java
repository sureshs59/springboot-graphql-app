package com.example.springboot.graphql.service;

import com.example.springboot.graphql.entity.Book;
import com.example.springboot.graphql.repository.BookRepository;
import com.example.springboot.graphql.repository.AuthorRepository;
import com.example.springboot.graphql.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Book Service
 */
@Service
@Transactional
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Book> getAllBooks() {
        logger.info("Fetching all books");
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        logger.info("Fetching book with ID: {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book createBook(String title, String isbn, Integer pageCount, Integer publishedYear,
                          String description, Double price, Long authorId, Long publisherId) {
        logger.info("Creating new book: {}", title);

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        if (price == null || price < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setPublishedYear(publishedYear);
        book.setDescription(description);
        book.setPrice(price);
        book.setAuthor(authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found")));
        book.setPublisher(publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RuntimeException("Publisher not found")));

        Book savedBook = bookRepository.save(book);
        logger.info("Book created with ID: {}", savedBook.getId());
        return savedBook;
    }

    public Book updateBook(Long id, String title, String isbn, Integer pageCount,
                          Integer publishedYear, String description, Double price) {
        logger.info("Updating book with ID: {}", id);

        Book book = getBookById(id);
        if (title != null && !title.isEmpty()) book.setTitle(title);
        if (isbn != null && !isbn.isEmpty()) book.setIsbn(isbn);
        if (pageCount != null) book.setPageCount(pageCount);
        if (publishedYear != null) book.setPublishedYear(publishedYear);
        if (description != null) book.setDescription(description);
        if (price != null && price >= 0) book.setPrice(price);

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        logger.info("Deleting book with ID: {}", id);
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
        return true;
    }

    public List<Book> getBooksByAuthor(Long authorId) {
        logger.info("Fetching books by author ID: {}", authorId);
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> searchBooksByTitle(String title) {
        logger.info("Searching books by title: {}", title);
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
}
