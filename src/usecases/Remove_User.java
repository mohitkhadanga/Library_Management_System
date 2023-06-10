package usecases;

import java.util.Scanner;

import dao.UserDaoImpl;
import dao.UserDaoIntr;

public class Remove_User {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserDaoIntr dao = new UserDaoImpl();
		
				//Delete a user
				System.out.println("Enter the user ID : ");
				
				int id = sc.nextInt();
				
				dao.deleteUser(id);

	}

}
