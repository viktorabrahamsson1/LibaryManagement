import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public abstract class User {
  private String name;
  private int userId;
  private HashMap<Book, LocalDate> borrowedBooks;

  public User(String name, int userId) {
    this.name = name;
    this.userId = userId;
    borrowedBooks = new HashMap<>();
  }

  public void borrowBook(Book book) {
    if (book == null) return;

    if (!book.isBorrowed()) {
      book.borrowBook();
      borrowedBooks.put(book, LocalDate.now().plusDays(7));
      System.out.println("You have now borrowed: " + book.getTitle());
    } else {
      System.out.println("Book is already borrowed");
    }
  }

  public void returnBook(Book book) {
    if (book == null) return;

    if (book.isBorrowed() && borrowedBooks.get(book) != null) {
      book.returnBook();
      borrowedBooks.remove(book);
      System.out.println("You have returned: " + book.getTitle() + ".");
    } else {
      System.out.println("This book is not borrowed or it is not your book.");
    }
  }

  public String getName() {
    return this.name;
  }

  public int getUserId() {
    return this.userId;
  }

  public void getFullInfo() {
    System.out.println("Information: " + "Name: " + this.getName() + ", UserId: " + this.getUserId());
  }

  public HashMap<Book, LocalDate> getBorrowed() {
    return borrowedBooks;
  }
}
