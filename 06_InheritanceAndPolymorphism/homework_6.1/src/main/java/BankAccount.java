public class BankAccount {


  public static void main(String[] args) {
    DepositAccount depositAccount = new DepositAccount();
    CardAccount cardAccount = new CardAccount();
    double x = 100.00;

    System.out.println(depositAccount.getAmount());

    cardAccount.put(1000);
    System.out.println(cardAccount.getAmount());

    System.out.println(cardAccount.send(depositAccount, x));

    System.out.println(depositAccount.getAmount());

    System.out.println(cardAccount.getAmount());

  }

  protected double accountBalance;

  public double getAmount() {

    return accountBalance;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0){
      accountBalance += amountToPut;
    }
    else {
      System.out.println("Операция не может быть выполнена.");
    }
  }

  public void take(double amountToTake) {
    if (amountToTake > 0 && amountToTake < accountBalance){
      accountBalance -= amountToTake;
    }
    else {
      System.out.println("Операция не может быть выполнена.");
    }
  }

  public boolean send(BankAccount receiver, double amount){
    take(amount);
    if (getAmount() < getAmount() + amount){
      receiver.put(amount);
      return true;
    }
    else {
      return false;
    }
  }
}
