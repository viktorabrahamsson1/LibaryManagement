public class Student extends User {
  private final double studentExpendedBorrowTime = 2;
  private final String school;


  public Student(String name, int userId, String school) {
    super(name, userId);
    this.school = school;
  }

  public String getSchool() {
    return this.school;
  }
}
