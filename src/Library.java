import java.util.ArrayList;


public class Library {
  private ArrayList<Book> books;
  private ArrayList<User> users;
  public UserActions userActions;
  public BookActions bookActions;
  private User loggedInUser;


  public Library() {
    books = new ArrayList<>();
    users = new ArrayList<>();
    loggedInUser = null;
    this.userActions = new UserActions(this);
    this.bookActions = new BookActions(this);
  }

  public ArrayList<User> getUsers() {
    return this.users;
  }

  public ArrayList<Book> getBooks() {
    return this.books;
  }

  public User getLoggedInUser() {
    return this.loggedInUser;
  }

  public void setLoggedInUser(User loggedInUser) {
    this.loggedInUser = loggedInUser;
  }
}

















