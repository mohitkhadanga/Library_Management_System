package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.User;
import database.DBUtil;
import exception.BookDaoException;
import exception.UserDaoException;

public class UserDaoImpl implements UserDaoIntr {
	
	private Connection conn;
	
	public UserDaoImpl () {
		conn = DBUtil.getConnection();
	}
	
	//User Login
	public boolean loginUser(String username, String password) {
		
		boolean checkLogin; //True or False
		
		String sql = "SELECT * FROM users WHERE userName = ? AND userPassword = ?";
		
		try(PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setString(1, username);
            statement.setString(2, password);
			
           ResultSet resultSet = statement.executeQuery();
           
           checkLogin = resultSet.next();
           
			return checkLogin;
		} 
		
		catch (SQLException e) {
            e.printStackTrace();
            return false;
		}
		
		
	}
	

	@Override
	public User getUserById(int userId) {
	    User user = null;

	    try {
	        String sql = "SELECT * FROM users WHERE userId = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, userId);

	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            user = new User();
	            user.setUserId(resultSet.getInt("userId"));
	            user.setUserName(resultSet.getString("userName"));
	            user.setPassword(resultSet.getString("userPassword"));  // Use "userPassword" instead of "password"
	        }

	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}



	@Override
	public void addUser(String userName, String userPassword) throws UserDaoException {

		try {
			String sql = "insert into users(userName, userPassword) values( ?, ? )";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, userName);
			statement.setString(2, userPassword);
			
			int rowsAffected = statement.executeUpdate();
			
			if (rowsAffected > 0) {
	            System.out.println("User added successfully");
	        } else {
	            System.out.println("Failed to add user");
	        }
			
			 statement.close();
			
		} catch (Exception e) {
			throw new UserDaoException("Error adding user: " + e.getMessage());
		}
		
	}

	@Override
	public void updateUser(User user) {
	    User existingUser = getUserById(user.getUserId());
	    if (existingUser == null) {
	        System.out.println("User with ID " + user.getUserId() + " does not exist.");
	        return;
	    }

	    try {
	        String sql = "UPDATE users SET userName = ?, userPassword = ? WHERE userId = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);

	        if (user.getUserName() != null) {
	            statement.setString(1, user.getUserName());
	        } else {
	            statement.setString(1, existingUser.getUserName());
	        }

	        if (user.getPassword() != null) {
	            statement.setString(2, user.getPassword());
	        } else {
	            statement.setString(2, existingUser.getPassword());
	        }

	        statement.setInt(3, user.getUserId());

	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("User updated successfully");
	        } else {
	            System.out.println("Failed to update user");
	        }

	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void deleteUser(int userId) {
	    // Check if the user exists or not
	    User check = getUserById(userId);

	    // Asking the user to enter a valid user ID till he doesn't provide a valid id
	    // Using Recursion
	    
	    if (check == null) {
	    	
	        System.out.println("User does not exist!");
	        
	        // Ask the user to enter a valid ID recursively
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a valid user ID: ");
	        int newId = sc.nextInt();
	        
	        deleteUser(newId); // Recursively call the method with the new ID 
	    }
	    
	    else {
	        String sql = "DELETE FROM users WHERE userId = ? ";

	        try (PreparedStatement statement = conn.prepareStatement(sql)) {

	            statement.setInt(1, userId);
	            int rowsAffected = statement.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("User with ID " + userId + " has been removed.");
	            } else {
	                System.out.println("Failed to delete user");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	}



	@Override
	public List<User> getAllUsers() {
	    List<User> users = new ArrayList<>();

	    String sql = "SELECT * FROM users";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            int userId = rs.getInt("userId");
	            String userName = rs.getString("userName");
	            String userPassword = rs.getString("userPassword");

	            User user = new User(userId, userName, userPassword);
	            users.add(user);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}


	@Override
    public List<User> getUsersWithUnreturnedBooks() throws BookDaoException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT users.userId, users.userName, users.userPassword " +
                     "FROM users " +
                     "INNER JOIN borrow ON users.userId = borrow.uId " +
                     "INNER JOIN books ON books.bookId = borrow.bId " +
                     "WHERE books.count > 0";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("userId");
                String username = rs.getString("userName");
                String password = rs.getString("userPassword");

                User user = new User(userId, username, password);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new BookDaoException("Error occurred while retrieving users with unreturned books: " + e.getMessage());
        }

        return users;
    }

	@Override
	public int getUserIdByUsernameAndPassword(String username, String password) throws UserDaoException {
	    int userId = -1;

	    String sql = "SELECT userId FROM users WHERE userName = ? AND userPassword = ?";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            userId = rs.getInt("userId");
	        }
	    } catch (SQLException e) {
	        throw new UserDaoException("Error occurred while retrieving user ID: " + e.getMessage());
	    }

	    return userId;
	}



}
