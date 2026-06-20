package com.example.springboot.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String name;
    private String email;
    private String country;
    private String biography;
    private Long createdAt;
    private Long updatedAt;
}
