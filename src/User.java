import java.time.LocalDate;
import java.util.HashMap;

public abstract class User {
  private String name;
  private String userId;
  private HashMap<Book, LocalDate> borrowedBooks;

  public User(String name, String userId) {
    this.name = name;
    this.userId = userId;
    borrowedBooks = new HashMap<>();
  }

  public String getName() {
    return this.name;
  }

  public String getUserId() {
    return this.userId;
  }

  public HashMap<Book, LocalDate> getBorrowed() {
    return borrowedBooks;
  }
}
