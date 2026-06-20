package com.example.springboot.graphql.service;

import com.example.springboot.graphql.entity.Author;
import com.example.springboot.graphql.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author Service
 */
@Service
@Transactional
public class AuthorService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        logger.info("Fetching all authors");
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        logger.info("Fetching author with ID: {}", id);
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public Author createAuthor(String name, String email, String country, String biography) {
        logger.info("Creating new author: {}", name);

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Author name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        Author author = new Author();
        author.setName(name);
        author.setEmail(email);
        author.setCountry(country);
        author.setBiography(biography);

        Author savedAuthor = authorRepository.save(author);
        logger.info("Author created with ID: {}", savedAuthor.getId());
        return savedAuthor;
    }

    public Author updateAuthor(Long id, String name, String email, String country, String biography) {
        logger.info("Updating author with ID: {}", id);

        Author author = getAuthorById(id);
        if (name != null && !name.isEmpty()) author.setName(name);
        if (email != null && !email.isEmpty()) author.setEmail(email);
        if (country != null && !country.isEmpty()) author.setCountry(country);
        if (biography != null) author.setBiography(biography);

        return authorRepository.save(author);
    }

    public boolean deleteAuthor(Long id) {
        logger.info("Deleting author with ID: {}", id);
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
        return true;
    }

    public Author getAuthorByName(String name) {
        logger.info("Fetching author by name: {}", name);
        return authorRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Author not found with name: " + name));
    }
}
