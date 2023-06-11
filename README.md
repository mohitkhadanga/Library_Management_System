# Library Management System

The Library Management System is a Java-based console application that allows users to manage books and user accounts in a library. It provides functionality for users to view books, borrow and return books, and manage their accounts. Additionally, administrators have access to administrative features such as adding and removing users, updating user information, and managing books.

## Features

- User Login/Sign up:
  - Users can create an account or login to an existing account.
- User Menu:
  - View all books: Users can see a list of all available books in the library.
  - Borrow a book: Users can borrow a book from the library.
  - Return a book: Users can return a previously borrowed book.
  - Delete my account: Users can remove their account from the system.
  - Go Back to the Previous menu: Users can navigate back to the main menu.
- Admin Login:
  - Administrators can log in to access administrative features.
- Admin Menu:
  - Add a user: Admins can add a new user to the system.
  - Remove a user: Admins can remove a user from the system.
  - View all users: Admins can view a list of all users in the system.
  - Update a user: Admins can update user information.
  - Show users with unreturned books: Admins can see a list of users who have not returned books.
  - Show user name by ID: Admins can retrieve a user's name by their ID.
  - Add a book: Admins can add a new book to the library.
  - Go back to the previous menu: Admins can navigate back to the main menu.
- Exit: Allows users to exit the Library Management System.

## Prerequisites

- Java Development Kit (JDK) installed
- Java IDE (such as Eclipse or IntelliJ) or a text editor to run the Java code

## How to Run

1. Clone this repository to your local machine or download the source code as a ZIP file.
2. Open the project in your Java IDE or a text editor.
3. Compile and run the `Main` class located in the `main` package.

## Technologies Used

- Java
- Java Database Connectivity (JDBC)
- MySQL for data storage
- Git & GitHub
- Eclipse IDE

## Project Structure

The project follows a package structure to organize the codebase:

- `bean`: Contains Java bean classes to represent entities like books and users.
- `dao`: Provides data access object (DAO) interfaces and their implementations to interact with the database.
- `database`: Handles the database connection and utility functions.
- `exception`: Defines custom exceptions for error handling.
- `usecases`: Contains classes representing different use cases of the Library Management System.
- `main`: Contains the `Main` class that serves as the entry point of the application.


## Lessons Learned
- Gained In-Depth knowledge on application of Core Java, JDBC and MySQL. 
- Enjoyed the process of creating the application.

## Author
- Name: Mohit Khadanga
- GitHub: [mohitkhadanga](https://github.com/mohitkhadanga)

## Acknowledgments
This program was developed as a solo project within 5 days.
