public class LegalPerson extends PhysicalPerson {

    static final double INTEREST_FOR_TAKE = 0.01;

    @Override
    public void take(double amountToTake) {
       if ((amountToTake + amountToTake * INTEREST_FOR_TAKE) <= accountBalance){
           accountBalance -= (amountToTake + amountToTake * INTEREST_FOR_TAKE);
       }
    }

    @Override
    protected String accountInformation() {

        return String.format("За пополнение счета комиссия - %d%%.\nЗа снятие со счета комиссия - %d%%." +
                "\nБаланс вашего счета - %.2f", 0, 1, getAmount());
    }
}
