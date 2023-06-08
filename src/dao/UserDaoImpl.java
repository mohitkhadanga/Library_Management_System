package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.User;
import database.DBUtil;
import exception.UserDaoException;

public class UserDaoImpl implements UserDaoIntr {
	
	private Connection conn;
	
	public UserDaoImpl () {
		conn = DBUtil.getConnection();
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
	            user.setPassword(resultSet.getString("password"));
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
		
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersWithUnreturnedBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
