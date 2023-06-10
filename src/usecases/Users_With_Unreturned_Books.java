package usecases;

import dao.UserDaoImpl;
import exception.BookDaoException;
import bean.User;

import java.util.List;

public class Users_With_Unreturned_Books {

    public static void main(String[] args) {
        // Create an instance of UserDaoImpl (Replace with your actual implementation)
        UserDaoImpl userDao = new UserDaoImpl();

        try {
            // Retrieve users with unreturned books
            List<User> usersWithUnreturnedBooks = userDao.getUsersWithUnreturnedBooks();

            // Display the users with unreturned books
            if (!usersWithUnreturnedBooks.isEmpty()) {
                System.out.println("Users with Unreturned Books:");
                for (User user : usersWithUnreturnedBooks) {
                    System.out.println("User ID: " + user.getUserId());
                    System.out.println("Username: " + user.getUserName());
                    System.out.println("Password: " + user.getPassword());
                    System.out.println("------------------------");
                }
            } else {
                System.out.println("No users found with unreturned books.");
            }
        } catch (BookDaoException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

