import java.util.ArrayList;
import java.util.Scanner;

public class BookActions {
  private Scanner scanner;
  private Library library;

  public BookActions(Library library) {
    scanner = new Scanner(System.in);
    this.library = library;
  }

  public Book findBook() {
    System.out.print("Enter book title: ");
    String title = scanner.nextLine();

    for (Book book : library.getBooks()) {
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
    library.getBooks().add(book);
  }

  public void removeBook() {
    Book book = findBook();

    if (!book.isBorrowed()) {
      library.getBooks().remove(book);
      System.out.println("The book: " + book.getTitle() + " was deleted.");
    } else {
      System.out.println("The book is currently being borrowed and cant be deleted.");
    }
  }


  public void borrowBookForUser() {
    User loggedInUser = library.getLoggedInUser();
    if (loggedInUser != null) {
      Book book = findBook();
      loggedInUser.borrowBookFromLibrary(book);
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void returnBookForUser() {
    User loggedInUser = library.getLoggedInUser();
    if (loggedInUser != null) {
      Book book = findBook();
      loggedInUser.returnBookToLibrary(book);
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void displayBooks() {
    ArrayList<Book> books = library.getBooks();
    if (books.isEmpty()) {
      System.out.println("No books available.");
      return;
    }

    for (Book book : books) {
      System.out.println("Book: " + book.getTitle() + ", borrowable: " + !book.isBorrowed());
    }
  }


}
