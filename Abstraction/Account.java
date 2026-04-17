import java.util.*;

abstract class Account{
  long accnum;
  String name;
  String branch;
  String IFSC;
  long phnum;
  Double balance;
  
  Account(long accnum, String name, String branch, String IFSC, long phnum, Double balance){
    this.accnum=accnum;
    this.name = name;
    this.branch = branch;
    this.IFSC=IFSC;
    this.phnum=phnum;
    this.balance = balance;
  }
  
  abstract void deposit(Double amt);
  abstract void withdraw(Double amt);
  abstract void transfer(long accnum, String branch, String IFSC);
  abstract void showdetails();
  
}

class Bank extends Account{
  
  Bank(long accnum, String name, String branch, String IFSC, long phnum, Double balance){
    super(accnum, name, branch, IFSC, phnum, balance);
  }
  
  @Override
  public void deposit(Double amt){
    balance += amt;
    System.out.println("Deposited amount with new balance: "+balance);
  }
  
  @Override
  public void withdraw(Double amt){
    if(amt > balance){
      System.out.println("Insufficient Balance.");
    }
    else{
      balance -= amt;
      System.out.println("Withdraw Succcesssful "+balance);
    }
  }
  
  @Override
  public void transfer(long accnum, String branch, String IFSC){
    System.out.println("Bank Changed");
    System.out.println("Account Number: "+accnum);
    System.out.println("Branch: "+branch);
    System.out.println("IFSC Code: "+IFSC);
  }
  
  @Override
  public void showdetails(){
    System.out.println("Account Number: "+accnum);
    System.out.println("Name: "+name);
    System.out.println("Branch: "+branch);
    System.out.println("IFSC Code: "+IFSC);
    System.out.println("Phone Number: "+phnum);
    System.out.println("Balance: "+balance);
  }
}

public class Main{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    
    Bank b = new Bank(12345678,"Joshua","Shollinganallur","SBI234456",73856394,7000.0);
    boolean a = true;
    while(a){
      System.out.println("Choice: ");
      System.out.println("1.Deposit \n 2.Withdraw\n3.Transfer account to another bank\n4.Show account details\n 5.Exit");
      System.out.println("Enter Choice");
      int choice = sc.nextInt();
      switch(choice)
      {
        case 1:
          
          System.out.println("Enter amt to be deposited:");
          Double amt = sc.nextDouble();
          b.deposit(amt);
          break;
          
        case 2:
          
          System.out.println("Enter amount to withdraw:");
           amt =  sc.nextDouble();
          b.withdraw(amt);
          break;
        
        case 3:
          System.out.print("\nEnter New Account Number: ");
          long acc = sc.nextLong();
          System.out.println("\nEnter new Branch Name: ");
          String br = sc.next();
          System.out.println("\nEnter new IFSC Code: ");
          String I = sc.next();
          b.accnum = acc;
          b.branch  = br;
          b.IFSC=I;
          
          b.transfer(acc, br, I);
          break;
          
        case 4:
          b.showdetails();
          break;
        
        case 5:
          System.out.println("Thank you");
          a=false;
          break;
        default:
          System.out.println("Invalid choice");
          a=false;
          break;
      }
    }
  }
}