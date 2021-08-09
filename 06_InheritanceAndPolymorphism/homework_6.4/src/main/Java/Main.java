package Company;

public class Main
{
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println(company.getIncome());
        System.out.println();
        hireEmployees(company);
        System.out.println(company.getIncome());
        System.out.println();
        highestSalarys(company);
        System.out.println();
        lowestSalarys(company);
        System.out.println();
        fireHalfEmployees(company);
        System.out.println();
        highestSalarys(company);
        System.out.println();
        lowestSalarys(company);
    }

    private static void hireEmployees(Company company){
        for (int i = 0; i < 180; i++){
            Operator operator = new Operator();
            company.hire(operator);
        }

        for (int i = 0; i < 80; i++){
            Manager manager = new Manager();
            company.hire(manager);
        }

        for (int i = 0; i < 10; i++){
            TopManager topManager = new TopManager();
            company.hire(topManager);
        }
        System.out.println("Принято на работу сотрудников - " + company.countEmployees());
    }

    private static void highestSalarys(Company company){
        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void lowestSalarys(Company company){
        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }
    }

    private static void fireHalfEmployees(Company company){
        for (int i = 0; i < company.countEmployees()/2; i++){
            int index = (int) (Math.random() * company.countEmployees());
            Employee dismissed = company.getEmployees().get(index);
            if (dismissed instanceof Manager && dismissed instanceof TopManager){
                company.fire(dismissed);
            }
        }
        System.out.println("Уволено сотрудников - " + company.countEmployees()/2);
    }
}
