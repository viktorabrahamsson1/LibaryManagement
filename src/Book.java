public class Book {
  private final String title;
  private boolean isBorrowed;

  public Book(String title) {
    this.title = title;
    this.isBorrowed = false;
  }

  public void getTitle() {
    System.out.println(this.title);
  }

  public boolean isBorrowed(){
    return this.isBorrowed;
  }

  public void borrowBook(){
    this.isBorrowed = true;
  }

  public void returnBook(){
    this.isBorrowed = false;
  }
}
