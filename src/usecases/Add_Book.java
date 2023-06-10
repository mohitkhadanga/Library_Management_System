package usecases;

import java.util.Scanner;

import dao.BooksDaoImpl;
import dao.BooksDaoIntr;
import exception.BookDaoException;

public class Add_Book {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BooksDaoIntr bookDao = new BooksDaoImpl();
		
		System.out.println("Enter book name : ");
        String bookName = sc.nextLine();
        
        System.out.println("Enter author name : ");
        String author = sc.nextLine();
        
        System.out.println("Enter published_year(yyyy-mm-dd) : ");
        String published_year = sc.next();
        
        System.out.println("Enter the count of books you want to add : ");
        int count = sc.nextInt();
        
        try {
			bookDao.addBook(bookName, author, published_year, count);
		} catch (BookDaoException e) {
			
		   System.out.println(e.getMessage());	
		}


	}

}
