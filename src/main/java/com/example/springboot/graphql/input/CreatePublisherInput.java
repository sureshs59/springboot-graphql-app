package com.example.springboot.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create Publisher Input
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePublisherInput {
    private String name;
    private String country;
    private String email;
    private String phone;
}
