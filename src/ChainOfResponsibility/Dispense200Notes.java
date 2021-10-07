package ChainOfResponsibility;

public class Dispense200Notes implements DispenseChain{
  private DispenseChain nextChain;

  @Override
  public void setNextChain(DispenseChain nextChain) {
    this.nextChain=nextChain;
    
  }

  @Override
  public void dispense(Currency cur) {
    // TODO Auto-generated method stub
    int amount=cur.getAmount();
    if(amount>200)
    {
      int noOfnotes=amount/200;
      int remaining=amount%200;
      System.out.println("Dispensed "+noOfnotes+" 200 note");
      if(remaining!=0)
        this.nextChain.dispense(new Currency(remaining));
      
    }else
    {
      this.nextChain.dispense(cur);
    }
      
}
}
