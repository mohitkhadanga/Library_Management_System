package usecases;

import java.util.Scanner;
import dao.BooksDaoImpl;
import dao.BooksDaoIntr;
import dao.UserDaoImpl;
import dao.UserDaoIntr;
import exception.BookDaoException;
import exception.UserDaoException;

public class Borrow_Book {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDaoIntr dao = new UserDaoImpl();
        BooksDaoIntr bookDao = new BooksDaoImpl();

        System.out.println("Enter your username : ");
        String username = sc.nextLine();

        System.out.println("Enter your password : ");
        String password = sc.nextLine();

        int userId = 0;
        try {
            userId = dao.getUserIdByUsernameAndPassword(username, password);
        } catch (UserDaoException e1) {
            e1.printStackTrace();
        }

        if (userId != -1) {
            System.out.println("Enter the Book Id You want to Borrow : ");
            int bookId = sc.nextInt();

            try {
                bookDao.borrowABook(userId, bookId);
            } catch (BookDaoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
}
