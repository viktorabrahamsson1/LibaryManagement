import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Library {
  private ArrayList<Book> books;
  private ArrayList<User> users;
  private Scanner scanner;
  private User loggedInUser;

  public Library() {
    books = new ArrayList<>();
    users = new ArrayList<>();
    scanner = new Scanner(System.in);
    loggedInUser = null;
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

  public void displayBooks() {

    if (books.isEmpty()) {
      System.out.println("No books avaiable.");
      return;
    }

    for (Book book : books) {
      System.out.println("Book: " + book.getTitle() + ", borrowable: " + book.isBorrowed());
    }
  }


  public void borrowBook() {
    if (loggedInUser != null) {
      loggedInUser.borrowBook();
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void returnBook() {
    if (loggedInUser != null) {
      loggedInUser.returnBook();
    } else {
      System.out.println("No user is logged in.");
    }
  }

  public void logIn() {
    User user = findUser();
    if (user != null) {
      loggedInUser = user;
    }
  }

  public User findUser() {
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    System.out.print("Enter your userId: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    for (User user : users) {
      if (user.getName().equals(name) && user.getUserId() == id) {
        return user;
      }
    }
    System.out.println("User was not found.");
    return null;
  }


  public void createUser() {
    String name;

    System.out.print("Are you a student or teacher: ");
    String typeOfUser = scanner.nextLine().toLowerCase();

    if (typeOfUser.equals("student") || typeOfUser.equals("teacher")) {
      System.out.print("Enter your name: ");
      name = scanner.nextLine();
      if (typeOfUser.equals("student")) {
        System.out.print("Enter your school: ");
        String school = scanner.nextLine();
        users.add(new Student(name, users.size(), school));
      } else {
        users.add(new Teacher(name, users.size()));
      }
    } else {
      System.out.println("Invalid user type (student/teacher)");
    }
  }

  public void removeUser() {
    System.out.print("Enter the userId to delete: ");
    int userIdToDelete = scanner.nextInt();
    scanner.nextLine();

    for (User user : users) {
      if (user.getUserId() == userIdToDelete) {
        users.remove(user);
        break;
      }
    }
  }

  public void displayUsers() {

    if (users.isEmpty()) {
      System.out.println("No users to display.");
      return;
    }

    for (User user : users) {
      System.out.println(user.getName());
    }
  }
}

















