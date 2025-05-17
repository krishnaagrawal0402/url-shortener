URL Shortener
A simple URL shortener application built with Java Spring Boot. This project provides a backend REST API for shortening URLs, tracking usage, and redirecting users. The repository is structured to support both backend and frontend code, with the frontend to be developed soon.
Table of Contents

Features
Project Structure
Getting Started
Running Locally
API Endpoints
Deployment
Frontend
Contributing
License

Features

Shorten long URLs to short, unique keys
Redirect to original URL via short link
Track number of clicks per short URL
RESTful API built with Spring Boot
PostgreSQL database integration
Ready for frontend integration

Project Structure
url-shortener/
├── backend/      # Spring Boot backend application
│   ├── src/
│   ├── pom.xml
│   └── ...
└── frontend/     # (To be developed) Frontend application
Getting Started
Prerequisites

Java 17+
Maven
PostgreSQL
Git

Running Locally

Clone the repository

bashgit clone https://github.com/<your-username>/url-shortener.git
cd url-shortener

Configure the database
Create a PostgreSQL database and update the connection settings in backend/src/main/resources/application.properties:

propertiesspring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

Build and run the backend

bashcd backend
mvn clean install
mvn spring-boot:run

API will be available at: http://localhost:8080/api

API Endpoints
MethodEndpointDescriptionPOST/api/shortenShorten a long URLGET/{shortKey}Redirect to original URL
Example usage:

Shorten a URL

bashcurl -X POST -H "Content-Type: application/json" \
  -d '{"url":"https://example.com"}' \
  http://localhost:8080/api/shorten

Redirect

Visit http://localhost:8080/abc123 in your browser



Deployment
This project is ready to deploy on platforms like Render or Heroku. You can set environment variables for your database credentials and configure build/start commands as needed.
Frontend
The frontend/ directory is reserved for the upcoming frontend application. Once developed, both backend and frontend will be managed in this single repository for easier deployment and maintenance.
Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.
License
This project is licensed under the MIT License.
Built with Java, Spring Boot, and ❤️
