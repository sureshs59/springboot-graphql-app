# Spring Boot GraphQL Application

A simple Spring Boot application with GraphQL API for managing Books, Authors, and Publishers.

## Features

✅ **GraphQL API** - Complete GraphQL schema for books management  
✅ **Spring Boot 3.1.5** - Latest framework  
✅ **Spring Data JPA** - Easy database access  
✅ **H2 Database** - In-memory database  
✅ **GraphiQL** - Interactive GraphQL IDE  
✅ **Query & Mutations** - Complete CRUD operations  
✅ **Relationships** - Author, Publisher, and Book relationships  
✅ **Unit Tests** - Comprehensive test coverage  
✅ **Docker Support** - Dockerfile included  

## Project Structure

```
springboot-graphql-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/springboot/graphql/
│   │   │   ├── entity/
│   │   │   │   ├── Author.java
│   │   │   │   ├── Publisher.java
│   │   │   │   └── Book.java
│   │   │   ├── repository/
│   │   │   │   ├── AuthorRepository.java
│   │   │   │   ├── PublisherRepository.java
│   │   │   │   └── BookRepository.java
│   │   │   ├── service/
│   │   │   │   ├── AuthorService.java
│   │   │   │   ├── PublisherService.java
│   │   │   │   └── BookService.java
│   │   │   ├── controller/
│   │   │   │   └── GraphQLController.java
│   │   │   ├── dto/
│   │   │   │   ├── AuthorDTO.java
│   │   │   │   ├── PublisherDTO.java
│   │   │   │   └── BookDTO.java
│   │   │   ├── input/
│   │   │   │   ├── CreateBookInput.java
│   │   │   │   ├── UpdateBookInput.java
│   │   │   │   ├── CreateAuthorInput.java
│   │   │   │   ├── UpdateAuthorInput.java
│   │   │   │   ├── CreatePublisherInput.java
│   │   │   │   └── UpdatePublisherInput.java
│   │   │   └── SpringBootGraphQLApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── graphql/
│   │           └── schema.graphqls
│   └── test/
│       └── java/com/example/springboot/graphql/
├── pom.xml
├── Dockerfile
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Docker (optional)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/sureshs59/springboot-graphql-app.git
cd springboot-graphql-app
```

### 2. Build the Application

```bash
mvn clean package
```

### 3. Run the Application

```bash
java -jar target/springboot-graphql-app-1.0.0.jar
```

## Access GraphQL

After starting the application, access GraphiQL at:

```
http://localhost:8080/graphiql
```

Or query at:

```
http://localhost:8080/graphql
```

## GraphQL Queries

### Get All Books

```graphql
query {
  books {
    id
    title
    isbn
    price
    author {
      id
      name
      email
    }
    publisher {
      id
      name
    }
  }
}
```

### Get Book by ID

```graphql
query {
  bookById(id: 1) {
    id
    title
    isbn
    pageCount
    publishedYear
    price
    author {
      name
    }
    publisher {
      name
    }
  }
}
```

### Search Books by Title

```graphql
query {
  searchBooks(title: "Java") {
    id
    title
    price
  }
}
```

### Get Books by Author

```graphql
query {
  booksByAuthor(authorId: 1) {
    id
    title
    isbn
  }
}
```

### Get All Authors

```graphql
query {
  authors {
    id
    name
    email
    country
    biography
  }
}
```

### Get Author by Name

```graphql
query {
  authorByName(name: "Josh Bloch") {
    id
    name
    email
    country
  }
}
```

### Get All Publishers

```graphql
query {
  publishers {
    id
    name
    country
    email
    phone
  }
}
```

## GraphQL Mutations

### Create Author

```graphql
mutation {
  createAuthor(input: {
    name: "Josh Bloch"
    email: "josh@example.com"
    country: "USA"
    biography: "Famous Java developer"
  }) {
    id
    name
    email
  }
}
```

### Create Publisher

```graphql
mutation {
  createPublisher(input: {
    name: "Addison Wesley"
    country: "USA"
    email: "info@addison.com"
    phone: "+1-234-567-8900"
  }) {
    id
    name
    email
  }
}
```

### Create Book

```graphql
mutation {
  createBook(input: {
    title: "Effective Java"
    isbn: "978-0-13-468599-1"
    pageCount: 464
    publishedYear: 2018
    description: "A guide to writing better Java programs"
    price: 45.99
    authorId: 1
    publisherId: 1
  }) {
    id
    title
    isbn
    price
    author {
      name
    }
  }
}
```

### Update Book

```graphql
mutation {
  updateBook(id: 1, input: {
    title: "Effective Java 3rd Edition"
    price: 49.99
  }) {
    id
    title
    price
  }
}
```

### Update Author

```graphql
mutation {
  updateAuthor(id: 1, input: {
    name: "Joshua Bloch"
    biography: "Chief Java Architect at Google"
  }) {
    id
    name
    biography
  }
}
```

### Update Publisher

```graphql
mutation {
  updatePublisher(id: 1, input: {
    phone: "+1-987-654-3210"
  }) {
    id
    name
    phone
  }
}
```

### Delete Book

```graphql
mutation {
  deleteBook(id: 1)
}
```

### Delete Author

```graphql
mutation {
  deleteAuthor(id: 1)
}
```

### Delete Publisher

```graphql
mutation {
  deletePublisher(id: 1)
}
```

## Running Tests

```bash
mvn test
```

## Build Docker Image

```bash
docker build -t springboot-graphql-app:latest .
```

## Run with Docker

```bash
docker run -p 8080:8080 springboot-graphql-app:latest
```

## API Endpoints

- **GraphQL Endpoint**: `http://localhost:8080/graphql`
- **GraphiQL UI**: `http://localhost:8080/graphiql`
- **Health Check**: `http://localhost:8080/health`
- **App Info**: `http://localhost:8080/info`
- **H2 Console**: `http://localhost:8080/h2-console`

## H2 Database Access

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

## Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.application.name=springboot-graphql-app
server.port=8080
spring.graphql.graphiql.enabled=true
```

## Database Schema

### Authors Table

```sql
CREATE TABLE authors (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  country VARCHAR(100) NOT NULL,
  biography TEXT,
  created_at BIGINT,
  updated_at BIGINT
);
```

### Publishers Table

```sql
CREATE TABLE publishers (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  country VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  phone VARCHAR(20),
  created_at BIGINT,
  updated_at BIGINT
);
```

### Books Table

```sql
CREATE TABLE books (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  isbn VARCHAR(20) NOT NULL UNIQUE,
  page_count INT NOT NULL,
  published_year INT NOT NULL,
  description TEXT,
  price DOUBLE NOT NULL,
  author_id BIGINT NOT NULL,
  publisher_id BIGINT NOT NULL,
  created_at BIGINT,
  updated_at BIGINT,
  FOREIGN KEY (author_id) REFERENCES authors(id),
  FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);
```

## Key Features Explained

### GraphQL Schema

- **Query**: Fetch data (books, authors, publishers)
- **Mutation**: Modify data (create, update, delete)
- **Types**: Book, Author, Publisher with their fields
- **Input Types**: For mutation parameters

### Service Layer

- Business logic for each entity
- Validation and error handling
- Transaction management

### Repository Layer

- Spring Data JPA repositories
- Custom query methods

## Troubleshooting

### GraphQL not working

1. Check if GraphQL endpoint is accessible: `http://localhost:8080/graphql`
2. Verify GraphiQL is enabled in `application.properties`
3. Check logs for errors

### Database connection issues

1. Verify H2 is properly configured
2. Check `application.properties` for correct database URL
3. Access H2 console to verify data

### Port already in use

Change port in `application.properties`:

```properties
server.port=9090
```

## Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

MIT License

## Support

For issues or questions, please create a GitHub issue.

## References

- [Spring GraphQL Documentation](https://spring.io/projects/spring-graphql)
- [GraphQL Official Documentation](https://graphql.org/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
