package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import database.DBUtil;
import exception.BookDaoException;

public class BooksDaoImpl implements BooksDaoIntr{
	
	// Establish a connection through constructor
	
	private Connection conn;
	public BooksDaoImpl () {
		conn = DBUtil.getConnection();
	}

	@Override
	public Book getBookById(int bookId) throws SQLException {
		
		Book book = null;
		
		String sql = "select * from books where bookId = ?";
		
		try(PreparedStatement ps = conn.prepareStatement(sql) ) {
			
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				
				book.setBookId(bookId);
				book.setBookName(rs.getString("bookName"));
				book.setAuthor(rs.getString("author"));
				book.setDate(rs.getString("published_year"));
				book.setCount(rs.getInt("count"));
				
			}
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
		
	}

	@Override
	public void addBook(String bookName, String author, String published_year, int count) throws BookDaoException{
		
		String sql = "INSERT INTO books (bookName, author, published_year, count) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setString(1, bookName);
			ps.setString(2, author);
			ps.setString(3, published_year);
			ps.setInt(4, count);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println("Book Added Successfully !");
			}
			else {
				System.out.println("Something went wrong...");
			}
			
		} catch (SQLException e) {
			throw new BookDaoException("Error occurred while adding book: " + e.getMessage());
		}
		
	}

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<>();
		
		String sql = "Select * from books";
		
		try(PreparedStatement ps = conn.prepareStatement(sql)) {
			
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
	
				 int bookID = rs.getInt("bookId");
				 String bookName = rs.getString("bookName");
				 String author = rs.getString("author");
				 String published_year = rs.getString("published_year");
				 int count = rs.getInt("count");
				 
				 Book book = new Book(bookID, bookName, author, published_year, count);
				 books.add(book);
			 }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return books;
	}

	@Override
	public void borrowABook(int userId, int bookId) throws BookDaoException {

	    try {
	        // Check if the book is available
	        String checkAvailabilityQuery = "SELECT count FROM books WHERE bookId = ?";
	        try (PreparedStatement checkAvailabilityPs = conn.prepareStatement(checkAvailabilityQuery)) {
	            checkAvailabilityPs.setInt(1, bookId);
	            ResultSet availabilityRs = checkAvailabilityPs.executeQuery();
	            
	            if (availabilityRs.next()) {
	                int count = availabilityRs.getInt("count");
	                
	                if (count >= 1) {
	                    // Book is available, proceed with borrowing
	                    String borrowQuery = "INSERT INTO borrow (bId, uId) VALUES (?, ?)";
	                    String updateCountQuery = "UPDATE books SET count = count - 1 WHERE bookId = ?";
	                    
	                    try (PreparedStatement borrowPs = conn.prepareStatement(borrowQuery);
	                         PreparedStatement updateCountPs = conn.prepareStatement(updateCountQuery)) {
	                        
	                        borrowPs.setInt(1, bookId);
	                        borrowPs.setInt(2, userId);
	                        
	                        int borrowResult = borrowPs.executeUpdate();
	                        
	                        if (borrowResult > 0) {
	                            updateCountPs.setInt(1, bookId);
	                            int updateCountResult = updateCountPs.executeUpdate();
	                            
	                            if (updateCountResult > 0) {
	                                System.out.println("Book borrowed successfully!");
	                            } else {
	                                throw new BookDaoException("Failed to update book count.");
	                            }
	                        } else {
	                            throw new BookDaoException("Failed to borrow the book.");
	                        }
	                    }
	                } else {
	                    throw new BookDaoException("Book is not available for borrowing.");
	                }
	            } else {
	                throw new BookDaoException("Book not found.");
	            }
	        }
	    } catch (SQLException e) {
	        throw new BookDaoException("Error occurred while borrowing a book: " + e.getMessage());
	    }
	}

	@Override
	public void returnBook(int userId, int bookId) throws BookDaoException {
	    try {
	        // Check if the user has borrowed the book
	        String checkBorrowQuery = "SELECT * FROM borrow WHERE bId = ? AND uId = ?";
	        try (PreparedStatement checkBorrowPs = conn.prepareStatement(checkBorrowQuery)) {
	            checkBorrowPs.setInt(1, bookId);
	            checkBorrowPs.setInt(2, userId);
	            ResultSet borrowRs = checkBorrowPs.executeQuery();
	            
	            if (borrowRs.next()) {
	                // User has borrowed the book, proceed with returning
	                String returnQuery = "DELETE FROM borrow WHERE bId = ? AND uId = ?";
	                String updateCountQuery = "UPDATE books SET count = count + 1 WHERE bookId = ?";
	                
	                try (PreparedStatement returnPs = conn.prepareStatement(returnQuery);
	                     PreparedStatement updateCountPs = conn.prepareStatement(updateCountQuery)) {
	                    
	                    returnPs.setInt(1, bookId);
	                    returnPs.setInt(2, userId);
	                    
	                    int returnResult = returnPs.executeUpdate();
	                    
	                    if (returnResult > 0) {
	                        updateCountPs.setInt(1, bookId);
	                        int updateCountResult = updateCountPs.executeUpdate();
	                        
	                        if (updateCountResult > 0) {
	                            System.out.println("Book returned successfully!");
	                        } else {
	                            throw new BookDaoException("Failed to update book count.");
	                        }
	                    } else {
	                        throw new BookDaoException("Failed to return the book.");
	                    }
	                }
	            } else {
	                throw new BookDaoException("The book is not borrowed by the user.");
	            }
	        }
	    } catch (SQLException e) {
	        throw new BookDaoException("Error occurred while returning a book: " + e.getMessage());
	    }
	}


}
