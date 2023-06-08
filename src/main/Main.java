package main;

import java.util.Scanner;

import bean.User;
import dao.UserDaoImpl;
import dao.UserDaoIntr;
import exception.UserDaoException;

public class Main {

	public static void main(String[] args) {
		
		UserDaoIntr dao = new UserDaoImpl();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("******* Welcome to Library Management System *******");
		System.out.println("Enter your choice : ");
		
		// Update a user
		
		boolean validOption = false;
		
		while (!validOption) {
			
			System.out.println("Enter the ID of the user you want to update: ");
	        int id = sc.nextInt();

	        // Check if the user exists
	        User existingUser = dao.getUserById(id);
	        if (existingUser == null) {
	            System.out.println("User with ID " + id + " does not exist.");
	            return; // Exit the main method
	        }

			System.out.println("Do you want to update:"
			        + "\n1. User name"
			        + "\n2. Password");
			int property = sc.nextInt();

			// Creating  a new user object , setting id, username(password unchanged)
			if (property == 1) {
			    System.out.println("Enter the new user name: ");
			    String newUserName = sc.next();
			    
			    User user = new User();
			    user.setUserId(id);
			    user.setUserName(newUserName);
			    
			    dao.updateUser(user);
			    validOption = true;
			} 
			 // Creating  a new user object , setting id, password (username unchanged)
			 else if (property == 2) {
			    System.out.println("Enter the new password: ");
			    String newPassword = sc.next();
			    
			    User user = new User();
			    user.setUserId(id);
			    user.setPassword(newPassword);
			    
			    dao.updateUser(user);
			    validOption = true;
			} else {
			    System.out.println("Please enter a valid option");
			}
			    
		}
	
		

		

	}

}
