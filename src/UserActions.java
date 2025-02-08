import java.util.ArrayList;
import java.util.Scanner;

public class UserActions {
  private Scanner scanner;
  private Library library;

  public UserActions(Library library) {
    scanner = new Scanner(System.in);
    this.library = library;
  }


  public User logIn() {
    User loggedInUser = library.getLoggedInUser();
    User user = findUser();
    if (user != null) {
      loggedInUser = user;
      return user;
    }
    return null;
  }

  public User logOut() {
    User loggedInUser = library.getLoggedInUser();

    if (loggedInUser != null) {
      loggedInUser = null;
    } else {
      System.out.println("You are already logged out.");
    }
    return null;
  }

  public User findUser() {
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();


    for (User user : library.getUsers()) {
      if (user.getName().equals(name)) {
        return user;
      }
    }
    System.out.println("User was not found.");
    return null;
  }


  public void createUser() {
    String name;
    ArrayList<User> users = library.getUsers();

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
    System.out.print("Enter the name to delete: ");
    String nameToDelete = scanner.nextLine();
    ArrayList<User> users = library.getUsers();
    User loggedInUser = library.getLoggedInUser();


    for (User user : users) {
      if (user.getName().equals(nameToDelete)) {
        users.remove(user);
        if (loggedInUser.equals(user)) {
          library.setLoggedInUser(null);
        }
        break;
      }
    }
  }

  public void displayBorrowedBook() {
    library.getLoggedInUser().getBorrowed();
  }

  public void displayUsers() {
    ArrayList<User> users = library.getUsers();
    if (users.isEmpty()) {
      System.out.println("No users to display.");
      return;
    }

    for (User user : users) {
      System.out.println(user.getName());
    }
  }
}
