package usecases;

import bean.User;
import dao.UserDaoImpl;
import dao.UserDaoIntr;
import bean.User;
import java.util.List;

public class Get_ALL_Users {

	public static void main(String[] args) {
				
		UserDaoIntr dao = new UserDaoImpl();
		
				// Get all users list
				List<User> users = dao.getAllUsers();

				System.out.println("+--------+----------+");
				System.out.println("| User ID | User Name |");
				System.out.println("+--------+----------+");

				for (User user : users) {
				    System.out.printf("| %6d | %-8s |\n", user.getUserId(), user.getUserName());
				}

				System.out.println("+--------+----------+");

	}

}
