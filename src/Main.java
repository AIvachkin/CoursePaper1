public class Main {

    static Employee [] fullName = new Employee[10] ;
    static float sumSalary = 0 ;
    static int minSalary = 10000000 ;
    static int maxSalary = 0 ;
    static float averageSalary = 0f ;
        public static void main(String[] args) {
            fullName[0] = new Employee("Иванов Иван Иванович", 1, 50_000) ;
            fullName[1] = new Employee("Петров Петр Петрович", 2, 27_900) ;
            fullName[2] = new Employee("Сидоров Сидр Сидорович", 3, 75_500) ;
            fullName[3] = new Employee("Ефимова Алла Николаевна", 4, 81_500) ;
            fullName[4] = new Employee("Москвин Анатолий Борисович", 5, 92_000) ;
            fullName[5] = new Employee("Фомина Наталья Аркадьевна", 1, 32_000) ;
            fullName[6] = new Employee("Лебедева Оксана Федоровна", 2, 28_200) ;
            fullName[7] = new Employee("Миронова Оксана Владимировна", 3, 68_400) ;
            fullName[8] = new Employee("Васин Василий Антонович", 4, 27_900) ;
            fullName[9] = new Employee("Симонов Семен Васильевич", 5, 88_000) ;

            print() ;
            System.out.println();
//            sumSalary();
//            System.out.println("Сумма затрат на з/п в месяц: " + sumSalary);
            minSalary();
            maxSalary () ;
            System.out.println();
            averageSalary();
            System.out.println("Минимальная з/п: " + minSalary);
            nameMinSalary();
            System.out.println("Максимальная з/п: " + maxSalary);
            nameMaxSalary();
            System.out.println("Средняя заработная плата: " +averageSalary);
            System.out.println();
            list();
        }

        public static void print() {
            for (Employee employee : fullName) {
                System.out.println(employee);
            }
        }

        public static void sumSalary () {

            for (Employee employee : fullName) {
                int temp = employee.getSalary();
                sumSalary += temp;
            }
        }

        public static void minSalary () {
            for (Employee employee : fullName) {
                int temp = employee.getSalary();
                if (minSalary >= temp) {
                    minSalary = temp;

                }
            }
        }
        public static void maxSalary () {
            for (Employee employee : fullName) {
                int temp = employee.getSalary();
                if (maxSalary <= temp) {
                    maxSalary = temp;

                }
            }
        }
        public static void nameMinSalary () {
            for (Employee employee : fullName) {
                if (employee.getSalary() == minSalary) {
                    System.out.println("Сотрудник с минимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
                }
            }
        }
        public static void nameMaxSalary () {
            for (Employee employee : fullName) {
                if (employee.getSalary() == maxSalary) {
                    System.out.println("Сотрудник с максимальной з/п: " + employee.getName() + " ; id: " + employee.getId());
                }
            }
        }
        public static void averageSalary (){
            sumSalary();
            averageSalary = sumSalary / fullName.length  ;
        }

        public static void list () {
            System.out.println("Список всех сотрудников");
            System.out.println("_______________________");
            for (Employee employee : fullName) {
                System.out.println(employee.getName());
            }
        }
}