class Employee{
  private String name;
  private int id;
  private int salary;
  public void setname(String name){
    this.name=name;
  }
  public String getname(){
    return name;
  }
  public void setid(int id){
    this.id=id;
  }
  public int getid(){
    return id;
    }
    public void setsalary(int salary){
      this.salary=salary;
    }
    public int getsalary(){
      return salary;
    }
}
public class main{ 
  public static void main(String[] args){
    Employee e=new Employee();
    e.setname("Hari");
    e.setid(123);
    e.setsalary(50000);
  }
}