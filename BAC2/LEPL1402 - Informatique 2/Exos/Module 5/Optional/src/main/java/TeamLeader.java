public class TeamLeader {

  private String name;
  private int age;

  public TeamLeader(){
      this.age = 0;
  }

  public TeamLeader(String name, int age){
      this.name = name;
      this.age = age;
  }

  public String getName(){
      return this.name;
  }

  public int getAge(){
      return this.age;
  }

  public void setAge(int age){
      this.age = age;
  }
}
