import java.util.*;

class Employee{
  private String name ="Ram";
  private  int empid = 123;
  private int salary = 50000;
  protected int salary2 =45000;
  
  public void setname(String name){
    this.name=name;
  }
  public String getname(){
    return name;
  }
  public void setempid(int empid){
    this.empid = empid;
  }
  public int getempid(){
    return empid;
  }
  public void setsalary(int salary){
    this.salary = salary;
  }
  public int getsalary(){
    return salary;
  }
  public void setsalary2(int salary2){
    this.salary2=salary2;
  }
  public int getsalary2(){
    return salary2;
  }
  public void display(){
    System.out.println(name);
    System.out.println(empid);
    System.out.println(salary);
    System.out.println(salary2);
  }
}
class company extends Employee{
  public void details(){
    System.out.println(salary2);
    super.display();
  }
}

public class Main{
  public static void main(String [] args){
    Employee emp = new Employee();
    
    company c = new company();
    c.details();
  }
}