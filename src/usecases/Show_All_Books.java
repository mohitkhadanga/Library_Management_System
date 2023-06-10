package usecases;

import java.util.List;
import dao.BooksDaoImpl;
import dao.BooksDaoIntr;
import bean.Book;

public class Show_All_Books {
    public static void main(String[] args) {
        BooksDaoIntr bookDao = new BooksDaoImpl();
        List<Book> books = bookDao.getAllBooks();

        if (!books.isEmpty()) {
            System.out.println("+--------+--------------------------+----------------+----------------+-------+");
            System.out.println("| bookId | bookName                 | author         | published_year | count |");
            System.out.println("+--------+--------------------------+----------------+----------------+-------+");

            for (Book book : books) {
                System.out.printf("| %-6d | %-24s | %-14s | %-14s | %-5d |\n",
                        book.getBookId(),
                        book.getBookName(),
                        book.getAuthor(),
                        book.getDate(),
                        book.getCount());
            }

            System.out.println("+--------+--------------------------+----------------+----------------+-------+");
        } else {
            System.out.println("No books found.");
        }
    }
}

