public abstract class Client {

    protected double accountBalance;

    public double getAmount() {

        return accountBalance;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0){
            accountBalance += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= accountBalance){
            accountBalance -= amountToTake;
        }
    }

}
