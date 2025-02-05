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
