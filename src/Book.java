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

  public void markAsBorrowed() {
    this.isBorrowed = true;
  }

  public void markAsReturned() {
    this.isBorrowed = false;
  }
}

