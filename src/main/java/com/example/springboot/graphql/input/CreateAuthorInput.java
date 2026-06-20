package com.example.springboot.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Author Input
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorInput {
    private String name;
    private String email;
    private String country;
    private String biography;
}
