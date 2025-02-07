import java.util.ArrayList;
import java.util.Scanner;

public class UserActions {
  private Scanner scanner;
  private ArrayList<User> users;
  User loggedInUser;

  public UserActions(ArrayList<User> users) {
    scanner = new Scanner(System.in);
    this.users = users;
  }


  public User logIn() {
    User user = findUser();
    if (user != null) {
      loggedInUser = user;
      return user;
    }
    return null;
  }

  public User logOut() {
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


    for (User user : users) {
      if (user.getName().equals(name)) {
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
