package com.example.springboot.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Book Input
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookInput {
    private String title;
    private String isbn;
    private Integer pageCount;
    private Integer publishedYear;
    private String description;
    private Double price;
    private Long authorId;
    private Long publisherId;
}
