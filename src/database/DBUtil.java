package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() {
		
		Connection conn = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Failed to load database driver.");
			 e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/web19sb101db";
		
		try {
			conn = DriverManager.getConnection(url,"root","Masoom@1234");
		} catch (SQLException e) {
			System.err.println("Failed to establish database connection.");
			e.printStackTrace();
		}

		return conn;
		
	}
	
	
}

