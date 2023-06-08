package dao;

import bean.User;
import bean.User;
import java.util.List;

public interface UserDaoIntr {
	
    User getUserById(int userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    List<User> getAllUsers();
    List<User> getUsersWithUnreturnedBooks();
    
}


