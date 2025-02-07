import java.util.ArrayList;
import java.util.Scanner;

public class BookActions {
  private Scanner scanner;
  private ArrayList<Book> books;
  public User loggedInUser;

  public BookActions() {
    scanner = new Scanner(System.in);
    books = new ArrayList<Book>();
  }

  public Book findBook() {
    System.out.print("Enter book title: ");
    String title = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }

    System.out.println("Book was not found.");
    return null;
  }

  public void addBook() {
    System.out.print("Enter the title of the book: ");
    String title = scanner.nextLine();
    Book book = new Book(title);
    books.add(book);
  }

  public void removeBook() {
    Book book = findBook();

    if (!book.isBorrowed()) {
      books.remove(book);
      System.out.println("The book: " + book.getTitle() + " was deleted.");
    } else {
      System.out.println("The book is currently being borrowed and cant be deleted.");
    }
  }


  public void borrowBook() {
    if (loggedInUser != null) {
      Book book = findBook();
      loggedInUser.borrowBook(book);
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void returnBook() {
    if (loggedInUser != null) {
      Book book = findBook();
      loggedInUser.returnBook(book);
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void displayBooks() {

    if (books.isEmpty()) {
      System.out.println("No books available.");
      return;
    }

    for (Book book : books) {
      System.out.println("Book: " + book.getTitle() + ", borrowable: " + !book.isBorrowed());
    }
  }


}
