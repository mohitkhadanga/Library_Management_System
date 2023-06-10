package dao;

import bean.Book;

public interface BooksDaoIntr {
	
	// Get book details by ID
	Book getBookById(int bookId);
	
	// Add a book
	void addBook(String bookName, String author, String published_year, int count);
	
	
}
