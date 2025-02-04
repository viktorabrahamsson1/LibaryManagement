import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  ArrayList<Book> books;
  Scanner scanner;

  public Library() {
    books = new ArrayList<Book>();
    scanner = new Scanner(System.in);
  }

  public void addBook() {
    String title = scanner.nextLine();
    Book book = new Book(title);
    books.add(book);
  }


  public void removeBook(String title) {

  }

  public void addUser(String user) {}

  public void removeUser(String user) {}

  public void displayBooks(){}

}
