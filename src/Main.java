import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иван", "Иванов", "Иванович", 45000, 3);
        employeeBook.addEmployee(new Employee("Иван", "Иванов", "Иванович", 35000, 2));
employeeBook.removeEmployee(1);
        employeeBook.print();
        System.out.println();
//            sumSalary();
        double sumSalary = employeeBook.sumSalary();
        System.out.printf(Locale.US, "Сумма затрат на з/п в месяц: %.2f%n", sumSalary);

        Employee minSalary = employeeBook.minSalary();
        Employee maxSalary = employeeBook.maxSalary();
        System.out.println();
        double averageSalary = employeeBook.averageSalary();
        System.out.println("Минимальная з/п: " + minSalary);
//        nameMinSalary();
        System.out.println("Максимальная з/п: " + maxSalary);
//        nameMaxSalary();
        System.out.printf(Locale.US, "Средняя заработная плата: %.2f%n", averageSalary);
        System.out.println();
        employeeBook.list();
        employeeBook.indexSalaries(10);
        System.out.println("Зп после индексации");
        employeeBook.print();
        System.out.println("Мин зп из 1 отдела: " + employeeBook.minSalaryFromDepartment(1));
        System.out.println("Мин зп из 10 отдела: " + employeeBook.minSalaryFromDepartment(10));
        System.out.println("Макс зп из 3 отдела: " + employeeBook.maxSalaryFromDepartment(3));
        System.out.println("Макс зп из 10 отдела: " + employeeBook.maxSalaryFromDepartment(10));
        System.out.printf("Сумма зп сотрудников из 5 отдела: %.2f%n", employeeBook.sumSalaryFromDepartment(5));
        System.out.printf(Locale.US, "Средняя заработная плата сотрудников 3 отдела " +
                "в месяц: %.2f%n", employeeBook.averageSalaryFromDepartment(3));
        employeeBook.indexSalariesFromDepartment(10, 2);
        System.out.println("После индексации для отдела 2");
        employeeBook.print();
        employeeBook.list();
        employeeBook.printEmployeesWithSalaryLessThan(55_000);
        employeeBook.printEmployeesWithSalaryGreaterOrEqualThan(55_000);
    }
}



