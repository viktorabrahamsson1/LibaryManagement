import java.util.Scanner;

public class Menu {
  private Library library;
  private Scanner scanner;

  public Menu() {
    library = new Library();
    scanner = new Scanner(System.in);
    boolean runLibrary = true;

    while (runLibrary) {
      int choice;

      if (library.getLoggedInUser() == null) {
        displayStartMenu();
        choice = getUserChoice();

        switch (choice) {
          case 1 -> library.setLoggedInUser(library.userActions.logIn());
          case 2 -> library.userActions.createUser();
          case 3 -> library.userActions.displayUsers();
          case 4 -> {
            System.out.println("Exiting the program...");
            scanner.close();
            runLibrary = false;
          }
          default -> System.out.println("Invalid choice, please try again.");
        }
      } else {
        displayLoggedInMenu();
        choice = getUserChoice();
        switch (choice) {
          case 1 -> library.setLoggedInUser(library.userActions.logOut());
          case 2 -> library.userActions.createUser();
          case 3 -> library.userActions.removeUser();
          case 4 -> library.bookActions.addBook();
          case 5 -> library.bookActions.removeBook();
          case 6 -> library.bookActions.borrowBookForUser();
          case 7 -> library.bookActions.returnBookForUser();
          case 8 -> library.userActions.displayBorrowedBook();
          case 9 -> library.bookActions.displayBooks();
          case 10 -> library.userActions.displayUsers();
          case 11 -> {
            System.out.println("Exiting the program...");
            scanner.close();
            runLibrary = false;
          }
          default -> System.out.println("Invalid choice, please try again.");
        }
      }


    }
  }

  private void displayStartMenu() {
    System.out.println("\nLibrary System Menu:");
    System.out.println("1. Log in");
    System.out.println("2. Create a new user");
    System.out.println("3. Display all users");
    System.out.println("4. Exit");
  }

  private void displayLoggedInMenu() {
    System.out.println("\nLibrary System Menu:");
    System.out.println("1. Log out");
    System.out.println("2. Create a new user");
    System.out.println("3. Remove a user");
    System.out.println("4. Add a new book");
    System.out.println("5. Remove a book");
    System.out.println("6. Borrow a book");
    System.out.println("7. Return a book");
    System.out.println("8. Display borrowed books");
    System.out.println("9. Display all books");
    System.out.println("10. Display all users");
    System.out.println("11. Exit");
  }


  // Method to get user's choice
  private int getUserChoice() {
    while (true) {
      try {
        System.out.print("\nEnter your choice: ");
        return scanner.nextInt(); // Read the user's choice
      } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Clear the buffer
      }
    }
  }
}
