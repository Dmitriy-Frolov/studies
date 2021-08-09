package Company;

import java.util.Random;

public class Manager extends Operator {
    //зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
    // Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
    private static final int MIN_AMOUNT_OF_MONEY_EARNED = 115000;
    private static final int MAX_AMOUNT_OF_MONEY_EARNED = 140000;
    private static final int INTEREST_FROM_THE_AMOUNT_OF_MONEY_EARNED = 5;
    private static final double BONUS_FROM_THE_AMOUNT_OF_MONEY_EARNED = 0.05;
    private static final int SALARY_MANAGER = 30000;
    private static int AMOUNT_OF_MONEY_EARNED = 0;

    @Override
    public int getMonthSalary() {
        int monthSalaryManager = SALARY_MANAGER + (int)(AMOUNT_OF_MONEY_EARNED * BONUS_FROM_THE_AMOUNT_OF_MONEY_EARNED);

        return monthSalaryManager;
    }

    @Override
    public int getIncomeForCompany() {
        AMOUNT_OF_MONEY_EARNED = (int) (MIN_AMOUNT_OF_MONEY_EARNED + Math.random() *
                ((MAX_AMOUNT_OF_MONEY_EARNED - MIN_AMOUNT_OF_MONEY_EARNED) + 1));

        return AMOUNT_OF_MONEY_EARNED;
    }

    @Override
    public String info() {
        return String.format("Менеджер - зарплата %.2f рублей (условия зарплаты: оклад + %d%% от заработанных денег для компании)",
                getMonthSalary(), INTEREST_FROM_THE_AMOUNT_OF_MONEY_EARNED);
    }
}