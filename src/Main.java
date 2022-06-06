import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        Employee ivan = new Employee("Иван", "Иванов", "Иванович", 35000, 2) ;
        employeeBook.addEmployee("Петр", "Иванов", "Иванович", 45000, 3);
        employeeBook.addEmployee("Петр", "Петров", "Иванович", 45000, 3);
        employeeBook.addEmployee(ivan);

        employeeBook.changeSalary(ivan, 43000);
//        employeeBook.changeDepartment(ivan, 3);
//        employeeBook.removeEmployee(1);
        employeeBook.print();
        System.out.println();
        employeeBook.printEmployeesByDepartment();
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


//    static Employee [] fullName = new Employee[10] ;
//    static float sumSalary = 0 ;
//    static int minSalary = 10000000 ;
//    static int maxSalary = 0 ;
//    static float averageSalary = 0f ;
//        public static void main(String[] args) {
//            fullName[0] = new Employee("Иванов Иван Иванович", 1, 50_000) ;
//            fullName[1] = new Employee("Петров Петр Петрович", 2, 27_900) ;
//            fullName[2] = new Employee("Сидоров Сидр Сидорович", 3, 75_500) ;
//            fullName[3] = new Employee("Ефимова Алла Николаевна", 4, 81_500) ;
//            fullName[4] = new Employee("Москвин Анатолий Борисович", 5, 92_000) ;
//            fullName[5] = new Employee("Фомина Наталья Аркадьевна", 1, 32_000) ;
//            fullName[6] = new Employee("Лебедева Оксана Федоровна", 2, 28_200) ;
//            fullName[7] = new Employee("Миронова Оксана Владимировна", 3, 68_400) ;
//            fullName[8] = new Employee("Васин Василий Антонович", 4, 27_900) ;
//            fullName[9] = new Employee("Симонов Семен Васильевич", 5, 88_000) ;

//            print() ;
//            System.out.println();
////            sumSalary();
////            System.out.println("Сумма затрат на з/п в месяц: " + sumSalary);
//            minSalary();
//            maxSalary () ;
//            System.out.println();
//            averageSalary();
//            System.out.println("Минимальная з/п: " + minSalary);
//            nameMinSalary();
//            System.out.println("Максимальная з/п: " + maxSalary);
//            nameMaxSalary();
//            System.out.println("Средняя заработная плата: " +averageSalary);
//            System.out.println();
//            list();
//        }
//
//        public static void print() {
//            for (Employee employee : fullName) {
//                System.out.println(employee);
//            }
//        }
//
//        public static void sumSalary () {
//
//            for (Employee employee : fullName) {
//                int temp = employee.getSalary();
//                sumSalary += temp;
//            }
//        }
//
//        public static void minSalary () {
//            for (Employee employee : fullName) {
//                int temp = employee.getSalary();
//                if (minSalary >= temp) {
//                    minSalary = temp;
//
//                }
//            }
//        }
//        public static void maxSalary () {
//            for (Employee employee : fullName) {
//                int temp = employee.getSalary();
//                if (maxSalary <= temp) {
//                    maxSalary = temp;
//
//                }
//            }
//        }
//        public static void nameMinSalary () {
//            for (Employee employee : fullName) {
//                if (employee.getSalary() == minSalary) {
//                    System.out.println("Сотрудник с минимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
//                }
//            }
//        }
//        public static void nameMaxSalary () {
//            for (Employee employee : fullName) {
//                if (employee.getSalary() == maxSalary) {
//                    System.out.println("Сотрудник с максимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
//                }
//            }
//        }
//        public static void averageSalary (){
//            sumSalary();
//            averageSalary = sumSalary / fullName.length  ;
//        }
//
//        public static void list () {
//            System.out.println("Список всех сотрудников");
//            System.out.println("_______________________");
//            for (Employee employee : fullName) {
//                System.out.println(employee.getName());
//            }
//        }
//}
//
