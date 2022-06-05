public class Employee {
    private static int counter = 0 ;
    private final int a ;

    private final String name ;
    private final String surname ;

    private final String patronymicName ;

    private double salary ;
    private int department ;
    private final int id ;

    public Employee(String name, String surname, String patronymicName, double salary, int department) {
        this.name = name;
        this.surname = surname;
        this.patronymicName = patronymicName;
        this.salary = salary;
        this.department = department;
        this.id = ++ counter ;
        this.a = 1 ;
    }



    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname) && patronymicName.equals(employee.patronymicName);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format(
                "id: %d, a: %d, ФИО: %s %s %s, ЗП: %.1f, номер отдела: %d ",
                id,
                a,
                surname,
                name,
                patronymicName,
                salary,
                department );
    }
}
