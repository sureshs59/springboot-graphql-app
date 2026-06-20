package com.example.springboot.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Publisher DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private Long id;
    private String name;
    private String country;
    private String email;
    private String phone;
    private Long createdAt;
    private Long updatedAt;
}
