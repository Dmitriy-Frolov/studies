package Company;

public class Operator implements Employee {
    //зарплата складывается только из фиксированной части.
    private static final int MONTH_SALARY_OPERATOR = 20000;
    @Override
    public int getMonthSalary() {

        return MONTH_SALARY_OPERATOR;
    }

    @Override
    public int getIncomeForCompany() {
        return 0;
    }

    @Override
    public String info() {
        return String.format("Оператор - зарплата %.2f рублей (условия зарплаты: оклад", getMonthSalary());
    }
}
