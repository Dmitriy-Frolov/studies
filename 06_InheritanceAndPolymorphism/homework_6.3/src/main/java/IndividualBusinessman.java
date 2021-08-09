public class IndividualBusinessman extends PhysicalPerson {

    static final double INTEREST_FOR_PUT_LESS_THAN_1000 = 0.01;
    static final double INTEREST_FOR_PUT_OVER_1000 = 0.005;

        public void put(double amountToPut) {
        if (amountToPut > 0 && amountToPut < 1000){
            accountBalance += (amountToPut - amountToPut * INTEREST_FOR_PUT_LESS_THAN_1000);
        }
        else if (amountToPut >= 1000){
            accountBalance += (amountToPut - amountToPut * INTEREST_FOR_PUT_OVER_1000);
        }
    }

    @Override
    protected String accountInformation() {

        return String.format("За пополнение счета комиссия - %d%%, если сумма пополнения менее 1000 рублей; " +
                "\n\t\t\t\t\t\t\t- %.1f%%, если сумма пополнения менее или равна 1000 рублей.\nЗа снятие со счета комиссия - %d%%." +
                "\nБаланс вашего счета - %.2f", 1, 0.5, 0, getAmount());
    }
}
