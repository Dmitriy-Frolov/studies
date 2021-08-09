public class PhysicalPerson extends Client {

    protected String accountInformation(){

        return String.format("За пополнение счета комиссия - %d%%.\nЗа снятие со счета комиссия - %d%%." +
                "\nБаланс вашего счета - %.2f", 0, 0, getAmount());
    }
}

