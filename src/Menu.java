import java.util.Scanner;

public class Menu {
  Library library;
  Scanner scanner;

  public Menu() {
    library = new Library();
    scanner = new Scanner(System.in);

    while (true) {
      displayMenu();
      int choice = getUserChoice(); // Get user's choice dynamically

      switch (choice) {
        case 1:
          library.createUser();
          break;
        case 2:
          library.logIn();
          break;
        case 3:
          library.displayBooks();
          break;
        case 4:
          library.addBook();
          break;
        case 5:
          library.removeBook();
          break;
        case 6:
          library.borrowBook();
          break;
        case 7:
          library.returnBook();
          break;
        case 8:
          library.displayUsers();
          break;
        case 9:
          library.removeUser();
          break;
        case 10:
          System.out.println("Exiting the program...");
          scanner.close();
          System.exit(0); // Exit the program
          break;
        default:
          System.out.println("Invalid choice, please try again.");
          break;
      }
    }
  }

  // Method to display the menu
  private void displayMenu() {
    System.out.println("\nLibrary System Menu:");
    System.out.println("1. Create a new user");
    System.out.println("2. Log in");
    System.out.println("3. Display all books");
    System.out.println("4. Add a new book");
    System.out.println("5. Remove a book");
    System.out.println("6. Borrow a book");
    System.out.println("7. Return a book");
    System.out.println("8. Display all users");
    System.out.println("9. Remove a user");
    System.out.println("10. Exit");
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
