package usecases;

import java.util.Scanner;

import dao.BooksDaoImpl;
import dao.BooksDaoIntr;
import dao.UserDaoImpl;
import dao.UserDaoIntr;

public class Get_User_By_Id {

	public static void main(String[] args) {
		
		UserDaoIntr dao = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Enter user Id : ");
		int userId = sc.nextInt();
		
		System.out.println("user name : " + dao.getUserById(userId).getUserName()
						   +"\n"+ "password : " + dao.getUserById(userId).getPassword());

	}

}
