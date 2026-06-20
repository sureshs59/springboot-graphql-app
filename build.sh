#!/bin/bash

echo "================================================"
echo "Spring Boot GraphQL Application Setup"
echo "================================================"

echo ""
echo "Building Maven project..."
mvn clean package

echo ""
echo "Build completed!"
echo ""
echo "To run the application:"
echo "  java -jar target/springboot-graphql-app-1.0.0.jar"
echo ""
echo "Then access GraphiQL at:"
echo "  http://localhost:8080/graphiql"
echo ""
echo "================================================"
