import java.util.ArrayList;
import java.util.Scanner;


public class Library {
  private ArrayList<Book> books;
  private ArrayList<User> users;
  private Scanner scanner;

  public Library() {
    books = new ArrayList<>();
    users = new ArrayList<>();
    scanner = new Scanner(System.in);
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

  public void displayBooks() {
    for (Book book : books) {
      System.out.println("Book: " + book.getTitle() + ", borrowable: " + book.isBorrowed());
    }
  }

  public Book findBook() {
    System.out.print("Enter book title: ");
    String title = scanner.nextLine();

    for (Book book : books) {
      if (book.getTitle().equals(title)) {
        return book;
      }
    }

    throw new IllegalArgumentException("Book not found: " + title);
  }

  public void borrowBook() {
    Book book = findBook();
    if (!book.isBorrowed()) {
      book.borrowBook();
      System.out.println("You have now borrowed: " + book.getTitle());
    } else {
      System.out.println("Book is already borrowed");
    }
  }

  public void returnBook() {
    Book book = findBook();

    if (book.isBorrowed()) {
      book.returnBook();
      System.out.println("You have returned: " + book.getTitle() + ".");
    } else {
      System.out.println("This book is not borrowed.");
    }
  }


  public void createUser() {
    String name;

    System.out.print("Are you a student or teacher: ");
    String typeOfUser = scanner.nextLine();

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

    for (User user : users) {
      if (user.getUserId() == userIdToDelete) {
        users.remove(user);
        break;
      }
    }
  }

  public void displayUsers() {
    for (User user : users) {
      System.out.println(user.getName());
    }
  }
}

















