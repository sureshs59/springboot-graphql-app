package com.example.springboot.graphql.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureGraphQlTester
public class GraphQLControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    public void testGetAllBooks() {
        graphQlTester
                .documentName("query-books")
                .execute()
                .path("data.books")
                .matchesJsonPath("$[*].id")
                .verify();
    }
}
