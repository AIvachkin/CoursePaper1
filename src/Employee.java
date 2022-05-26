public class Employee {

    public String name ;
    public int department ;
    public int salary ;

    public int id ;

    private static int counter = 0 ;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = ++ counter ;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return "id: " + id + ", ФИО: " + name + ", отдел: " + department + ", з/п: " + salary;
    }
}
