package ChainOfResponsibility;

import java.util.Scanner;

public class ATMMachine {
  private DispenseChain c1;
  public ATMMachine()
  {
    this.c1=new Dispense500Notes();
    DispenseChain c2=new Dispense200Notes();
    DispenseChain c3=new Dispense100Notes();
    c1.setNextChain(c2);
    c2.setNextChain(c3);
    
  }
  public static void main(String[] args)
  {
    ATMMachine atm=new ATMMachine();
    System.out.println("enter amount to be withdrawn");
    Scanner sc=new Scanner(System.in);
    int amount=sc.nextInt();
    if(amount%100!=0)
    {
      System.out.println("enter amount in multiple of 100");
      return;
    }
    atm.c1.dispense(new Currency(amount));
    
  }
}
