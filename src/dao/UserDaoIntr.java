package dao;

import bean.User;
import exception.BookDaoException;
import exception.UserDaoException;
import bean.User;
import java.util.List;

public interface UserDaoIntr {
	
	//User Login
	boolean loginUser(String username, String password);
	
	// Get user details by ID
    User getUserById(int userId);
    
    //Get user id by username and password
    int getUserIdByUsernameAndPassword(String username, String password) throws UserDaoException;
    
    // Add a user
    void addUser(String userName, String userPassword) throws UserDaoException ;
    
    //Update the user
    void updateUser(User user);
    
    // Delete a user 
    void deleteUser(int userId);
    
    // Get all users
    List<User> getAllUsers();
    
    // Get users with unreturned books
    List<User> getUsersWithUnreturnedBooks() throws BookDaoException;
    
}


