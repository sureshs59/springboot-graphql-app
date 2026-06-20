package com.example.springboot.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Integer pageCount;
    private Integer publishedYear;
    private String description;
    private Double price;
    private Long authorId;
    private Long publisherId;
    private Long createdAt;
    private Long updatedAt;
}
