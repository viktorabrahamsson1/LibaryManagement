public class Teacher extends User {
  public final int extendedBorrowTime = 2;

  public Teacher(String name, int userId) {
    super(name, userId);
  }

  public int getExtendedBorrowTime() {
    return this.extendedBorrowTime;
  }
}
