package Company;

public class TopManager extends Operator {
    //зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы,
    // если доход компании более 10 млн рублей.
    private final int INTERST_FROM_THE_SALARY = 150;
    private static final double BONUS_FROM_THE_SALARY = 1.5;
    private static int SALARY_TOP_MANAGER = 60000;
    private static final int INCOME_COMPANY = 10000000;
    private static int MONTH_SALARY = 0;

    @Override
    public int getMonthSalary() {
        if (Company.getIncome() > INCOME_COMPANY){
            MONTH_SALARY = SALARY_TOP_MANAGER + (int) (SALARY_TOP_MANAGER * BONUS_FROM_THE_SALARY);
        }
        else {
            MONTH_SALARY = SALARY_TOP_MANAGER;
        }

        return MONTH_SALARY;
    }

    @Override
    public int getIncomeForCompany() {
        return super.getIncomeForCompany();
    }

    @Override
    public String info() {
        return String.format("Топ менеджер - зарплата %.2f рублей (условия зарплаты: оклад + %d%% оклада, " +
                "если доход компании превысил %d рублей", getMonthSalary(), INTERST_FROM_THE_SALARY, INCOME_COMPANY);
    }
}
