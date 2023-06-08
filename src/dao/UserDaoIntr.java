package dao;

import bean.User;
import exception.UserDaoException;
import bean.User;
import java.util.List;

public interface UserDaoIntr {
	
	// Get user details by ID
    User getUserById(int userId);
    
    // Add a user
    void addUser(String userName, String userPassword) throws UserDaoException ;
    
    //Update the user
    void updateUser(User user);
    
    // Delete a user 
    void deleteUser(int userId);
    
    // Get all users
    List<User> getAllUsers();
    
    // Get users with unreturned books
    List<User> getUsersWithUnreturnedBooks();
    
}


