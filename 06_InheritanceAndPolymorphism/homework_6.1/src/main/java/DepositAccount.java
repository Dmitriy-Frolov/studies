import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;


    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
        lastIncome = LocalDate.now();
    }

    public void take(double amountToTake) {
        if (amountToTake < accountBalance && !lastIncome.equals(lastIncome.plusMonths(1))){
            accountBalance -= amountToTake;
        }
    }
}
