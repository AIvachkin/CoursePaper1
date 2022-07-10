import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeBook {

    private final Employee[] fullName;

    //    public EmployeeBook() {
//        fullName = new Employee[10];
//        for (int i = 0; i < fullName.length; i++) {
//            fullName[i] = generateFullname(i + 1, (int) (1 + (5 - 1 + 1) * Math.random()));
//        }
//    }
    public EmployeeBook() {
        fullName = new Employee[10];
//        for (int i = 0; i < fullName.length; i++) {
//            fullName[i] = generateFullname(i + 1, (int) (1 + (5 - 1 + 1) * Math.random()));
//        }
    }

//    public static Employee generateFullname(int i, int department) {
//        int start = 30_000;
//        int end = 80_000;
//        return new Employee(
//                "Иван" + i,
//                "Иванов" + i,
//                "Иванович" + i,
//                start + (end - start) * Math.random(),
//                department);
//    }

    public void print() {
         Stream.of(fullName)
                .filter(Objects::nonNull)
                .forEach(fullName->System.out.println(fullName.getName() + " " +
                        fullName.getSurname() + " " +
                        fullName.getPatronymicName()));


//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee)) {
//                System.out.println(employee);
//            }
//        }
    }

    public double sumSalary() {
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .mapToDouble(Employee::getSalary)
                .sum();


//        double sumSalary = 0;
//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee)) {
//                sumSalary += employee.getSalary();
//            }
//        }
//        return sumSalary;
    }

    public void printEmployeesByDepartment() {
        //по условию отделы от 1 до 5
        for (int department = 1; department <= 5; department++) {
            System.out.println("Сотрудники из отдела " + department);
//            перешли на стримы
            int finalDepartment = department;
            Stream.of(fullName)
                    .filter(Objects::nonNull)
                    .filter(fullName -> fullName.getDepartment() == finalDepartment)
                    .forEach(fullName -> System.out.println(fullName.getName() + " " +
                            fullName.getSurname() + " " +
                            fullName.getPatronymicName()));

//            for (Employee employee : fullName) {
//                if (Objects.nonNull(employee) && employee.getDepartment() == department) {
//                    System.out.println(employee.getName() + " " +
//                            employee.getSurname() + " " +
//                            employee.getPatronymicName());
//                }

//            }
//            printAllEmployees(department);
        }
    }

    public double sumSalaryFromDepartment(int department) {
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment()==department)
                .mapToDouble(Employee::getSalary)
                .sum();

//        double sumSalary = 0;
//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
//                sumSalary += employee.getSalary();
//            }
//        }
//        return sumSalary;
    }

    public Employee minSalary() {

        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);


//        double minSalary = Double.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.nonNull(fullName[i]) && minSalary >= fullName[i].getSalary()) {
//                minSalary = fullName[i].getSalary();
//                index = i;
//            }
//        }
//        if (index != -1) {
//            return fullName[index];
////        return minSalary ;
//        } else return null;

    }

    public Employee minSalaryFromDepartment(int department) {
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);

//        double minSalary = Double.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.nonNull(fullName[i]) && fullName[i].getDepartment() == department && fullName[i].getSalary() < minSalary) {
//                minSalary = fullName[i].getSalary();
//                index = i;
//            }
//        }
//        if (index != -1) {
//            return fullName[index];
////        return minSalary ;
//        } else return null;

    }

    public Employee maxSalary() {
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);


//        double maxSalary = Double.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.nonNull(fullName[i]) && maxSalary < fullName[i].getSalary()) {
//                maxSalary = fullName[i].getSalary();
//                index = i;
//            }
//        }
//        if (index != -1) {
//            return fullName[index];
//        } else return null;

    }

    public Employee maxSalaryFromDepartment(int department) {
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);


//        double maxSalary = Double.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.nonNull(fullName[i]) && fullName[i].getDepartment() == department && fullName[i].getSalary() > maxSalary) {
//                maxSalary = fullName[i].getSalary();
//                index = i;
//            }
//        }
//        if (index != -1) {
//            return fullName[index];
//        } else return null;

    }

    public void printEmployeesWithSalaryLessThan(double bound) {
        String result = Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getSalary() < bound)
                .map(fullName -> String.format("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        fullName.getId(),
                        fullName.getSurname(),
                        fullName.getName(),
                        fullName.getPatronymicName(),
                        fullName.getSalary()))
                .collect(Collectors.joining("\n", "Сотрудники с зп меньшей, чем "
                        + bound + "\n" , "\n"));
        System.out.println(result);

//        System.out.println("Сотрудники с зп меньшей, чем " + bound);
//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getSalary() < bound) {
//                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
//                        employee.getId(),
//                        employee.getSurname(),
//                        employee.getName(),
//                        employee.getPatronymicName(),
//                        employee.getSalary()
//                );
//            }
//        }

    }

    public void printEmployeesWithSalaryGreaterOrEqualThan(double bound) {
        String result = Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getSalary() >= bound)
                .map(fullName -> String.format("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        fullName.getId(),
                        fullName.getSurname(),
                        fullName.getName(),
                        fullName.getPatronymicName(),
                        fullName.getSalary()))
                .collect(Collectors.joining("\n", "Сотрудники с зп большей, чем "
                        + bound + "\n" , "\n"));
        System.out.println(result);


//        System.out.println("Сотрудники с зп большей, чем " + bound);
//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getSalary() >= bound) {
//                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
//                        employee.getId(),
//                        employee.getSurname(),
//                        employee.getName(),
//                        employee.getPatronymicName(),
//                        employee.getSalary()
//                );
//            }
//        }
    }

    public double averageSalary() {
        return sumSalary() / fullName.length;
    }

    public void changeSalary(
            Employee employee,
            double newSalary) {
        Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(ful -> ful.equals(fullName))
                .forEach(ful -> ful.setSalary(newSalary));

//        for (Employee value : fullName) {
//            if (Objects.equals(employee, value)) {
//                value.setSalary(newSalary);
//            }
//        }
    }

    public void changeDepartment(
            Employee employee,
            int newDepartment) {
        Stream.of(fullName)
                .filter(ful -> ful.equals(fullName))
                .forEach(ful -> ful.setDepartment(newDepartment));

//        for (Employee value : fullName) {
//            if (Objects.equals(employee, value)) {
//                value.setDepartment(newDepartment);
//            }
//        }
    }

    public void addEmployee(Employee employee) {
        Stream.iterate(0, i -> i + 1)
                .limit(fullName.length - 1)
                .filter(i -> Objects.isNull(fullName[i]))
                .findFirst()
                .ifPresent(i -> fullName[i] = employee);


//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.isNull(fullName[i])) {
//                fullName[i] = employee;
//                break;
//            }
//        }
    }

    public void addEmployee(String name,
                            String surname,
                            String patronymicName,
                            double salary,
                            int department) {
        addEmployee(new Employee(name, surname, patronymicName, salary, department));

    }

    public void removeEmployee(Employee employee) {
        Stream.iterate(0, i -> i + 1)
                .limit(fullName.length - 1)
                .filter(i -> Objects.equals(fullName[i], employee))
                .findFirst()
                .ifPresent(i -> fullName[i] = null);


//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.equals(fullName[i], employee)) {
////                    ||
////            Objects.nonNull(fullName[i]) && Objects.nonNull(employee) && fullName[i].getDepartment() == employee.getDepartment()) {
//                fullName[i] = null;
//            }
//        }
    }

    public void removeEmployee(int id) {
        Stream.iterate(0, i -> i + 1)
                .limit(fullName.length - 1)
                .filter(i -> Objects.nonNull(fullName[i]) && fullName[i].getId() == id)
                .findFirst()
                .ifPresent(i -> fullName[i] = null);


//        for (int i = 0; i < fullName.length; i++) {
//            if (Objects.nonNull(fullName[i]) && fullName[i].getId() == id) {
//                fullName[i] = null;
//            }
//        }
    }


    public void indexSalariesFromDepartment(double index, int department) {
        Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment() == department)
                .forEach(fullName -> fullName.setSalary(fullName.getSalary() + fullName.getSalary() * index / 100));

//
//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
//                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
//            }
    }


    public void list() {
        System.out.println("Список всех сотрудников");
        System.out.println("_______________________");
        for (Employee employee : fullName) {
            if (Objects.nonNull(employee)) {
                System.out.printf(employee.getSurname() + " " + employee.getName() + " " +
                        employee.getPatronymicName() + " " + "%.2f%n", employee.getSalary());
            }
        }
    }

    public void printAllEmployees(int department) {
        String result = Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment()==department)
                .map(fullName -> String.format("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
                        fullName.getId(),
                        fullName.getSurname(),
                        fullName.getName(),
                        fullName.getPatronymicName(),
                        fullName.getSalary()))
                .collect(Collectors.joining("\n"));
        System.out.println(result);



//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
//                System.out.printf("id: %d, ФИО: %s %s %s, ЗП: %.2f%n",
//                        employee.getId(),
//                        employee.getSurname(),
//                        employee.getName(),
//                        employee.getPatronymicName(),
//                        employee.getSalary()
//                );
//
//            }
//        }
    }

    public double averageSalaryFromDepartment(int department) {
//        double totalSalaryFromDepartment = 0;
//        int count = 0;
        return Stream.of(fullName)
                .filter(Objects::nonNull)
                .filter(fullName -> fullName.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);


//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee) && employee.getDepartment() == department) {
//                totalSalaryFromDepartment += employee.getSalary();
//                count++;
//            }
//        }
//        if (totalSalaryFromDepartment == 0) {
//            return 0;
//        } else return totalSalaryFromDepartment / count;
    }

    public void indexSalaries(double index) {
        Stream.of(fullName)
                .filter(Objects::nonNull)
                .forEach(fullName -> fullName.setSalary(fullName.getSalary() + fullName.getSalary() * index / 100));


//        for (Employee employee : fullName) {
//            if (Objects.nonNull(employee)) {
//                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
//            }
//        }
    }
}
