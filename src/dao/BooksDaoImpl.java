package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Book;
import database.DBUtil;

public class BooksDaoImpl implements BooksDaoIntr{
	
	// Establish a connection through constructor
	
	private Connection conn;
	public BooksDaoImpl () {
		conn = DBUtil.getConnection();
	}

	@Override
	public Book getBookById(int bookId) {
		
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
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}

	@Override
	public void addBook(String bookName, String author, String published_year, int count) {
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
