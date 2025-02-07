import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Library {
  private ArrayList<Book> books;
  private ArrayList<User> users;
  public UserActions userActions;
  public BookActions bookActions;

  public Library() {
    books = new ArrayList<>();
    users = new ArrayList<>();
    this.userActions = new UserActions(this.users);
    this.bookActions = new BookActions();
  }
}

















