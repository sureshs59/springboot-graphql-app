package com.example.springboot.graphql.repository;

import com.example.springboot.graphql.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Publisher Repository
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Optional<Publisher> findByName(String name);
    Optional<Publisher> findByEmail(String email);
}
