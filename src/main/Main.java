package main;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.User;
import dao.BooksDaoImpl;
import dao.BooksDaoIntr;
import dao.UserDaoImpl;
import dao.UserDaoIntr;
import exception.UserDaoException;


public class Main {

	public static void main(String[] args) {

        UserDaoIntr dao = new UserDaoImpl();
        dao.BooksDaoIntr bookDao = new dao.BooksDaoImpl();

        Scanner sc = new Scanner(System.in);

        System.out.println("******* Welcome to Library Management System *******");
        
        System.out.println("Enter your choice : ");

        System.out.println("Enter book name : ");
        String bookName = sc.nextLine();
        
        System.out.println("Enter author name : ");
        String author = sc.nextLine();
        
        System.out.println("Enter published_year name : ");
        String published_year = sc.next();
        
        System.out.println("Enter the count of books you want to add : ");
        int count = sc.nextInt();
        
        bookDao.addBook(bookName, author, published_year, count);
        
    }

}
