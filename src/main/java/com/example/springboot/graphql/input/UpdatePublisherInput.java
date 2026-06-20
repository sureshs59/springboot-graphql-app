package com.example.springboot.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Update Publisher Input
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePublisherInput {
    private String name;
    private String country;
    private String email;
    private String phone;
}
