public class CardAccount extends BankAccount {


    public void take(double amountToTake) {
        if (amountToTake > 0 && amountToTake < accountBalance){
            accountBalance -= (amountToTake + amountToTake * 0.01);
        }
    }
}
