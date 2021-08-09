import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
        /*
        staff.sort((o1, o2) -> {
            if (o1.getSalary() > o2.getSalary()){return 1;}
            if (o1.getSalary() < o2.getSalary()){return -1;}
            if (o1.getSalary().equals(o2.getSalary())){
                if (o1.getName().compareTo(o2.getName()) > 0){return 1;}
                if (o1.getName().compareTo(o2.getName()) < 0){return -1;}
            }
            return 0;
        });
         */
        staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        for (Employee employee : staff){
            System.out.println(employee);
        }
    }
}