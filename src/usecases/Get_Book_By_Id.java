package usecases;

import java.sql.SQLException;
import java.util.Scanner;

import dao.BooksDaoImpl;
import dao.BooksDaoIntr;

public class Get_Book_By_Id {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		BooksDaoIntr bookDao = new BooksDaoImpl();

        System.out.println("Enter the Book ID : ");
        int bookId = sc.nextInt();

        bean.Book book = bookDao.getBookById(bookId);
        if (book != null) {
            System.out.println("+----------------------+----------------------------+");
            System.out.printf("| %-20s | %-25s |\n", "Book Name", book.getBookName());
            System.out.printf("| %-20s | %-25s |\n", "Author", book.getAuthor());
            System.out.printf("| %-20s | %-25s |\n", "Published Year", book.getDate());
            System.out.printf("| %-20s | %-25s |\n", "Count", book.getCount());
            System.out.println("+----------------------+----------------------------+");
        } else {
            System.out.println("Book not found!");
        }

	}

}
