package Company;

import java.util.*;

public class Company  {

    public static final List<Employee> employees = new ArrayList<>();
    public static int incomeCompany = 0;

    public void hire(Employee employee){
        employees.add(employee);
        //найм одного содрудника.
    }

    public void hireAll(Collection<Employee> employees){
        employees.addAll(employees);
        //найм списка содрудников.
    }

    public void fire(Employee employee){
        employees.remove(employee);
        //увольнение сотрудника.
    }

    public static int getIncome(){
        for (Employee employee : employees){
           incomeCompany += employee.getIncomeForCompany();
        }
        //получение значения дохода компании.

        return incomeCompany;
    }

    public List<Employee> getTopSalaryStaff(int count){
        List<Employee> copyList = new ArrayList<Employee>(employees);
        copyList.sort(Comparator.comparing(Employee::getMonthSalary).reversed());
        List<Employee> result = new ArrayList<Employee>();
        if (count <= countEmployees()){
            for (int i = 0; i < count; i++){
                result.add(copyList.get(i));
            }
        }

        return result;

//        return getFilteredLimitedList(count, new Comparator<Employee>(){
//            public int compare(Employee o1, Employee o2){
//                return o2.getMonthSalary() - o1.getMonthSalary();
//            }
//        });
    }

    public List<Employee> getLowestSalaryStaff(int count){
        List<Employee> copyList = new ArrayList<Employee>(employees);
        copyList.sort(Comparator.comparing(Employee::getMonthSalary));
        List<Employee> result = new ArrayList<Employee>();
        if (count <= countEmployees()){
            for (int i = 0; i < count; i++){
                result.add(copyList.get(i));
            }
        }
        return result;
//        return getFilteredLimitedList(count, new Comparator<Employee>(){
//            public int compare(Employee o1, Employee o2){
//                return o1.getMonthSalary() - o2.getMonthSalary();
//            }
//        });
    }

//    private List<Employee> getFilteredLimitedList(int count, Comparator<Employee> comparator){
//        List<Employee> copyList = new ArrayList<Employee>(employees);
//        copyList.sort(Comparator.comparing(Employee::getMonthSalary));
//        //Collections.sort(copyList, comparator);
//        List<Employee> result = new ArrayList<Employee>();
//        for (int i = 0; i < count; i++){
//            result.add(copyList.get(i));
//        }
//        return result;
//    }

    public static int countEmployees(){

        return employees.size();
    }

    public List<Employee> getEmployees(){

        return employees;
    }

}
