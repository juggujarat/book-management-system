📚 Book Management System
A full-stack CRUD application built with Spring Boot for the backend and ReactJS for the frontend, utilizing PostgreSQL for data storage, and supporting basic CRUD operations for managing books.

💻 Backend
A Spring Boot application using JPA for database interactions and PostgreSQL as the database.

🌐 Frontend
A React.js application to interact with the backend and provide a user-friendly interface.

🔧 Technologies Used
Backend:

Spring Boot
Spring Data JPA
PostgreSQL
Spring Web (REST API)

Frontend:
React.js
Axios (for API calls)


⚙️ Backend Setup
The backend is built using Spring Boot and JPA for managing book data in a PostgreSQL database.

Prerequisites
Java 17 or higher
Maven
PostgreSQL
Steps to Run Backend
Clone the repository:
git clone https://github.com/juggujarat/book-management-system.git
cd backend

Setup PostgreSQL Database:

Install PostgreSQL if it's not installed.
Create a new database (cred_app) in PostgreSQL or modify the application.properties file to point to your existing database.
Configure Database:

Open src/main/resources/application.properties and update your PostgreSQL credentials:
spring.datasource.url=jdbc:postgresql://localhost:5432/book-management-system
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


Install Backend Dependencies:
Make sure Maven is installed, then run:
 mvn clean install
Run the Backend:
Start the backend server:
mvn spring-boot:run
The backend will be running at http://localhost:8080 🚀.

⚛️ Frontend Setup
The frontend is built using React.js.

Prerequisites
Node.js (version 16 or higher)
npm (comes with Node.js)
Steps to Run Frontend

cd frontend
Install Dependencies:
Run the following command to install the necessary Node.js packages:
npm install
Start the React Development Server:
npm start
The frontend will be running at http://localhost:3000 🌟.


🔌 API Endpoints
The backend exposes the following API endpoints:

Create Book (POST) - /api/book
Request body: BookRequest (title, author, etc.)
Response: BookResponse (book details)

Get Book by ID (GET) - /api/book/{id}
Path Variable: id (book ID)
Response: BookResponse (book details)

Get All Books (GET) - /api/book
Response: List of BookResponse (all books)

Update Book (PUT) - /api/book/{id}
Path Variable: id (book ID)
Request body: BookRequest (updated book details)
Response: BookResponse (updated book details)

Delete Book (DELETE) - /api/book/{id}
Path Variable: id (book ID)
Response: HTTP status code (204 if deleted, 404 if not found) 🗑️.

📁 Folder Structure
bash
Copy
backend/        # Contains the Spring Boot application.
└── src/main/java/book_management/_system/   # Java source files (Controllers, Services, Entities).
└── src/main/resources/                       # Configuration files (application.properties).

frontend/       # Contains the React.js application.
└── src/        # React components and application logic.
└── public/     # Static assets (images, favicon, etc.).


