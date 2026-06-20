package com.example.springboot.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Update Author Input
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorInput {
    private String name;
    private String email;
    private String country;
    private String biography;
}
