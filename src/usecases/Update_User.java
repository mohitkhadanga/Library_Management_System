package usecases;

import java.util.Scanner;

import bean.User;
import dao.UserDaoImpl;
import dao.UserDaoIntr;

public class Update_User {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserDaoIntr dao = new UserDaoImpl();
		
		boolean validOption = false;

		while (!validOption) {
		    while (true) {
		        System.out.println("Enter the ID of the user you want to update: ");
		        int id = sc.nextInt();

		        // Check if the user exists
		        User existingUser = dao.getUserById(id);
		        if (existingUser == null) {
		            System.out.println("User with ID " + id + " does not exist. Please enter a valid ID.");
		        } else {
		            System.out.println("Do you want to update:"
		                    + "\n1. User name"
		                    + "\n2. Password");
		            int property = sc.nextInt();

		            // Creating a new user object, setting id, username (password unchanged)
		            if (property == 1) {
		                System.out.println("Enter the new user name: ");
		                String newUserName = sc.next();

		                User user = new User();
		                user.setUserId(id);
		                user.setUserName(newUserName);

		                dao.updateUser(user);
		                validOption = true;
		                break; // Exit the inner loop
		            }
		            // Creating a new user object, setting id, password (username unchanged)
		            else if (property == 2) {
		                System.out.println("Enter the new password: ");
		                String newPassword = sc.next();

		                User user = new User();
		                user.setUserId(id);
		                user.setPassword(newPassword);

		                dao.updateUser(user);
		                validOption = true;
		                break; // Exit the inner loop
		            } else {
		                System.out.println("Please enter a valid option");
		            }
		        }
		    }
		}


	}

}
