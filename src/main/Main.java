package main;

import java.util.Scanner;

import usecases.Add_Book;
import usecases.Add_User;
import usecases.Borrow_Book;
import usecases.Get_ALL_Users;
import usecases.Get_Book_By_Id;
import usecases.Get_User_By_Id;
import usecases.Remove_User;
import usecases.Return_Book;
import usecases.Show_All_Books;
import usecases.Update_User;
import usecases.Users_With_Unreturned_Books;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("******* Welcome to Library Management System *******");
        System.out.println("Enter your choice:");

        int choice;
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Login/Sign up as a user");
            System.out.println("2. Login as an Admin");
            System.out.println("3. Exit");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    userMenu(sc);
                    break;
                case 2:
                    adminMenu(sc);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Library Management System!");
        sc.close();
    }

    private static void userMenu(Scanner sc) {
        System.out.println("User Menu");
        System.out.println("1. View all Books");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Delete my account");
        System.out.println("5. Go Back to the Previous menu");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                Show_All_Books.main(null);
                break;
            case 2:
                Borrow_Book.main(null);
                break;
            case 3:
                Return_Book.main(null);
                break;
            case 4:
                // Code to delete user account
                break;
            case 5:
                // Go back to the previous menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static void adminMenu(Scanner sc) {
        System.out.println("Admin Menu");
        System.out.println("Enter Admin name:");
        String adminName = sc.nextLine();
        System.out.println("Enter Admin password:");
        String adminPassword = sc.nextLine();

        if (adminName.equals("Admin") && adminPassword.equals("Admin123")) {
            System.out.println("Authentication successful! Welcome, Admin.");
            System.out.println("1. Add a user");
            System.out.println("2. Remove a user");
            System.out.println("3. View all users");
            System.out.println("4. Update a user");
            System.out.println("5. Show users with unreturned books");
            System.out.println("6. Show user name by ID");
            System.out.println("7. Add a book");
            System.out.println("8. Go back to the previous menu");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    Add_User.main(null);
                    break;
                case 2:
                    Remove_User.main(null);
                    break;
                case 3:
                    Get_ALL_Users.main(null);
                    break;
                case 4:
                    Update_User.main(null);
                    break;
                case 5:
                    Users_With_Unreturned_Books.main(null);
                    break;
                case 6:
                    Get_User_By_Id.main(null);
                    break;
                case 7:
                    Add_Book.main(null);
                    break;
                case 8:
                    // Go back to the previous menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } else {
            System.out.println("Authentication failed! Invalid admin name or password.");
        }
    }

}
