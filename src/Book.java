public class Book {
  private final String title;
  private boolean isBorrowed;

  public Book(String title) {
    this.title = title;
    this.isBorrowed = false;
  }

  public String getTitle() {
    return this.title;
  }

  public boolean isBorrowed() {
    return this.isBorrowed;
  }

  public void borrowBook() {
    this.isBorrowed = true;
  }

  public void returnBook() {
    this.isBorrowed = false;
  }
}

