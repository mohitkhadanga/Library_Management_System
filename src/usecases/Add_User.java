package usecases;

import java.util.Scanner;

import dao.UserDaoImpl;
import dao.UserDaoIntr;
import exception.UserDaoException;

public class Add_User {

	public static void main(String[] args) {
		
		UserDaoIntr dao = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		// Register a user
				try {
			        System.out.println("Enter User Name : ");
			        String userName = sc.next();
			        System.out.println("Enter Password : ");
			        String userPassword = sc.next();
			        
			        dao.addUser(userName, userPassword);
			    } catch (UserDaoException e) {
			        System.out.println("Failed to add user: " + e.getMessage());
			    }


	}

}
