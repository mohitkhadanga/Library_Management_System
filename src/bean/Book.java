package bean;

public class Book {

    private int bookId;
    private String bookName;
    private String date;
    private String author;
    private int count;


    public Book() {
        super();
    }

    public Book(int bookId, String bookName, String date, String author, int count) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.date = date;
        this.author = author;
        this.count = count;
       
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", date=" + date + ", author=" + author + ", count="
                + count + ", publishedYear=" + "]";
    }
}
