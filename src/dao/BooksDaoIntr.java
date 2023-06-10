package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Book;
import bean.User;
import exception.BookDaoException;

public interface BooksDaoIntr {
	
	//Show all books
	List<Book> getAllBooks();
	
	//Borrow a Book
	void borrowABook(int userId, int bookId) throws BookDaoException;
	
	// Get book details by ID
	Book getBookById(int bookId) throws SQLException;
	
	// Add a book
	void addBook(String bookName, String author, String published_year, int count) throws BookDaoException ;
	
	//Return a book
	 void returnBook(int userId, int bookId) throws BookDaoException;
}
