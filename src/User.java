import java.time.LocalDate;
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

  public abstract int getExtendedBorrowTime();

  public void borrowBookFromLibrary(Book book) {
    if (book == null) return;

    if (!book.isBorrowed()) {
      book.markAsBorrowed();
      borrowedBooks.put(book, LocalDate.now().plusDays(7 * getExtendedBorrowTime()));
      System.out.println("You have now borrowed: " + book.getTitle());
    } else {
      System.out.println("Book is already borrowed");
    }
  }

  public void returnBookToLibrary(Book book) {
    if (book == null) return;

    if (book.isBorrowed() && borrowedBooks.get(book) != null) {
      book.markAsReturned();
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

  public void getBorrowed() {
    if (borrowedBooks.isEmpty()) {
      System.out.println("No borrowed books.");
    } else {
      borrowedBooks.forEach((book, dueDate) -> {
        System.out.println("Book: " + book.getTitle() + " is due on: " + dueDate);
      });
    }
  }
}
