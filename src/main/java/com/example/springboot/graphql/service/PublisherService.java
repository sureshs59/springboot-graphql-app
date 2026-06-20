package com.example.springboot.graphql.service;

import com.example.springboot.graphql.entity.Publisher;
import com.example.springboot.graphql.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Publisher Service
 */
@Service
@Transactional
public class PublisherService {

    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        logger.info("Fetching all publishers");
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        logger.info("Fetching publisher with ID: {}", id);
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));
    }

    public Publisher createPublisher(String name, String country, String email, String phone) {
        logger.info("Creating new publisher: {}", name);

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Publisher name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setCountry(country);
        publisher.setEmail(email);
        publisher.setPhone(phone);

        Publisher savedPublisher = publisherRepository.save(publisher);
        logger.info("Publisher created with ID: {}", savedPublisher.getId());
        return savedPublisher;
    }

    public Publisher updatePublisher(Long id, String name, String country, String email, String phone) {
        logger.info("Updating publisher with ID: {}", id);

        Publisher publisher = getPublisherById(id);
        if (name != null && !name.isEmpty()) publisher.setName(name);
        if (country != null && !country.isEmpty()) publisher.setCountry(country);
        if (email != null && !email.isEmpty()) publisher.setEmail(email);
        if (phone != null) publisher.setPhone(phone);

        return publisherRepository.save(publisher);
    }

    public boolean deletePublisher(Long id) {
        logger.info("Deleting publisher with ID: {}", id);
        if (!publisherRepository.existsById(id)) {
            throw new RuntimeException("Publisher not found with id: " + id);
        }
        publisherRepository.deleteById(id);
        return true;
    }
}
