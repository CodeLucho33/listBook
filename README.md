# LiterAlura

LiterAlura is a project developed as part of the backend challenge for Oracle Next Education. This application focuses on managing information about books and authors using modern backend technologies.

## Project Description

LiterAlura allows users to search, register, and manage books and authors. It integrates with the Gutendex API for advanced book searches and provides various features for a seamless experience.

## Features

### Book Search by Title
- Search for books using the Gutendex API and store them in the database, avoiding duplicates.

### Book Management
- List all registered books in the database.

### Author Management
- List all registered authors, including relevant details.

### Alive Authors in a Specific Year
- Filter authors who were alive in a specific year based on available data.

### Books by Language
- Filter registered books by their language using standard language codes (e.g., `ES`, `EN`, `FR`, `PT`).

### Additional Features
#### Book Recommendation System
- Suggest books based on user searches or book popularity (number of accesses).

#### Book Ratings and Reviews
- Allow users to rate and review books. Ratings range from 1 to 5 stars.

#### Search History
- Save and display a history of previous searches for user convenience.

#### Book Categories and Genres
- Classify books by genre (e.g., novel, poetry, science fiction) or category (e.g., education, entertainment).

#### Statistics and Reports
- Generate insights such as:
    - Most searched books.
    - Most popular authors.
    - Most queried languages.
- Export these reports in CSV or JSON formats.

## Technologies Used
- **Java 21**: The core programming language.
- **Spring Boot**: Framework for fast and secure web application development.
- **Spring Data JPA**: Handles data persistence with ease.
- **PostgreSQL**: Relational database to store book and author information.
- **Gutendex API**: External source for advanced book searches.
- **Maven**: Dependency management and project build tool.

## Prerequisites

Ensure the following are installed on your system:
- Java 21.
- PostgreSQL (with a database configured for the project).
- Maven.
- Internet connection for Gutendex API access.

## Installation and Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/LiterAlura.git
