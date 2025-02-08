public class Student extends User {
  public final int extendedBorrowTime = 3;
  private final String school;


  public Student(String name, int userId, String school) {
    super(name, userId);
    this.school = school;
  }

  public int getBorrowTimeMultiplier() {
    return this.extendedBorrowTime;
  }

  public String getSchool() {
    return this.school;
  }
}
