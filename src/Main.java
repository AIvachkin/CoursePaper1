import java.util.Locale;
import java.util.Random;

public class Main {

    private static final Employee[] FULLNAME = new Employee[10];

    static double maxSalary = 0;
    static float averageSalary = 0f;

    public static void main(String[] args) {
        for (int i = 0; i < FULLNAME.length; i++) {
            FULLNAME[i] = generateFullname(i + 1, (int) (1 + (5 - 1 + 1) * Math.random()));
//                System.out.println(FULLNAME[i]);

        }

        print();
        System.out.println();
//            sumSalary();
        double sumSalary = sumSalary();
        System.out.printf(Locale.US,"Сумма затрат на з/п в месяц: %.2f%n", sumSalary);

        Employee minSalary = minSalary();
        Employee maxSalary = maxSalary();
        System.out.println();
        double averageSalary = averageSalary();
        System.out.println("Минимальная з/п: " + minSalary);
//        nameMinSalary();
        System.out.println("Максимальная з/п: " + maxSalary);
//        nameMaxSalary();
        System.out.printf(Locale.US,"Средняя заработная плата: %.2f%n", averageSalary);
        System.out.println();
        list();
        indexSalaries(10);
        System.out.println("Зп после индексации");
        print();
        System.out.println("Мин зп из 1 отдела: " + minSalaryFromDepartment(1));
        System.out.println("Мин зп из 10 отдела: " + minSalaryFromDepartment(10));
        System.out.println("Макс зп из 3 отдела: " + maxSalaryFromDepartment(3));
        System.out.println("Макс зп из 10 отдела: " + maxSalaryFromDepartment(10));
        System.out.printf("Сумма зп сотрудников из 5 отдела: %.2f%n", sumSalaryFromDepartment(5));
        System.out.printf(Locale.US,"Средняя заработная плата сотрудников 3 отдела " +
                "в месяц: %.2f%n", averageSalaryFromDepartment(3));
        indexSalariesFromDepartment(10, 2);
        System.out.println("После индексации для отдела 2");
        print();
        list();
        printEmployeesWithSalaryLessThan(55_000);
        printEmployeesWithSalaryGreaterOrEqualThan(55_000);
    }

    private static Employee generateFullname(int i, int department) {
        int start = 30_000;
        int end = 80_000;
        return new Employee(
                "Иван" + i,
                "Иванов" + i,
                "Иванович" + i,
                start + (end - start) * Math.random(),
                department);
    }

    private static void print() {
        for (Employee employee : FULLNAME) {
            System.out.println(employee);
        }
    }

    public static double sumSalary() {
        double sumSalary = 0;
        for (Employee employee : FULLNAME) {
            sumSalary += employee.getSalary();
        }
        return sumSalary ;
    }
    public static double sumSalaryFromDepartment(int department) {
        double sumSalary = 0;
        for (Employee employee : FULLNAME) {
            if (employee.getDepartment()==department){
            sumSalary += employee.getSalary();
        }
    }
        return sumSalary ;
    }

    public static Employee minSalary() {
        double minSalary = Double.MAX_VALUE;
        int index = -1 ;
        for (int i=0; i < FULLNAME.length; i++) {
            if (minSalary >= FULLNAME[i].getSalary()) {
                minSalary = FULLNAME[i].getSalary();
                index = i ;
            }
        }
        if (index != -1) {
        return FULLNAME[index] ;
//        return minSalary ;
        }
        else return null ;

    }
        public static Employee minSalaryFromDepartment(int department) {
        double minSalary = Double.MAX_VALUE;
        int index = -1 ;
        for (int i=0; i < FULLNAME.length; i++) {
            if (FULLNAME[i].getDepartment() == department && FULLNAME[i].getSalary() < minSalary) {
                minSalary = FULLNAME[i].getSalary();
                index = i ;
            }
        }
        if (index != -1) {
        return FULLNAME[index] ;
//        return minSalary ;
        }
        else return null ;

    }
    private static Employee maxSalary() {
        double maxSalary = Double.MIN_VALUE;
        int index = -1 ;
        for (int i=0; i < FULLNAME.length; i++) {
            if (maxSalary < FULLNAME[i].getSalary()) {
                maxSalary = FULLNAME[i].getSalary();
                index = i ;
            }
        }
        if (index != -1) {
            return FULLNAME[index] ;
        } else return null ;

    }
        private static Employee maxSalaryFromDepartment(int department) {
        double maxSalary = Double.MIN_VALUE;
        int index = -1 ;
        for (int i=0; i < FULLNAME.length; i++) {
            if (FULLNAME[i].getDepartment() == department && FULLNAME[i].getSalary()>maxSalary) {
                maxSalary = FULLNAME[i].getSalary();
                index = i ;
            }
        }
        if (index != -1) {
            return FULLNAME[index] ;
        } else return null ;

    }

    private static void printEmployeesWithSalaryLessThan(double bound){
        System.out.println("Сотрудники с зп меньшей, чем " + bound);
        for (Employee employee:FULLNAME){
            if (employee.getSalary()<bound){
                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getSurname(),
                        employee.getName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                        );
            }
        }

    }
    private static void printEmployeesWithSalaryGreaterOrEqualThan(double bound){
        System.out.println("Сотрудники с зп большей, чем " + bound);
        for (Employee employee:FULLNAME){
            if (employee.getSalary() >= bound){
                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        employee.getId(),
                        employee.getSurname(),
                        employee.getName(),
                        employee.getPatronymicName(),
                        employee.getSalary()
                        );
            }
        }

    }

//    public static void maxSalary() {
//        for (Employee employee : FULLNAME) {
//            double temp = employee.getSalary();
//            if (maxSalary <= temp) {
//                maxSalary = temp;
//
//            }
//        }
//    }

//    public static void nameMinSalary() {
//        for (Employee employee : FULLNAME) {
//            if (employee.getSalary() == minSalary) {
//                System.out.println("Сотрудник с минимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
//            }
//        }
//    }

//    public static void nameMaxSalary() {
//        for (Employee employee : FULLNAME) {
//            if (employee.getSalary() == maxSalary) {
//                System.out.println("Сотрудник с максимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
//            }
//        }
//    }
    private static void indexSalaries(double index) {
        for (Employee employee:FULLNAME) {
            employee.setSalary(employee.getSalary()+employee.getSalary()*index/100);
        }
    }
    private static void indexSalariesFromDepartment(double index, int department) {
        for (Employee employee:FULLNAME) {
            if (employee.getDepartment()==department){
            employee.setSalary(employee.getSalary()+employee.getSalary()*index/100);
        }
    }}
    private static double averageSalary() {
        return sumSalary() / FULLNAME.length;
    }
    private static double averageSalaryFromDepartment (int department) {
        double totalSalaryFromDepartment = 0 ;
        int count = 0 ;
        for (Employee employee:FULLNAME) {
            if (employee.getDepartment() == department){
                totalSalaryFromDepartment += employee.getSalary();
                count ++ ;
            }
        }
        if (totalSalaryFromDepartment == 0) {
            return 0 ;
        } else return totalSalaryFromDepartment/count ;
    }
    

    public static void list() {
        System.out.println("Список всех сотрудников");
        System.out.println("_______________________");
        for (Employee employee : FULLNAME) {
            System.out.printf(employee.getSurname() + " " + employee.getName() + " " +
                    employee.getPatronymicName() + " " + "%.2f%n",employee.getSalary());
        }
    }}
