import org.w3c.dom.ls.LSOutput;

public class Main {

    static Employee [] fullName = new Employee[10] ;
        public static void main(String[] args) {
            fullName[0] = new Employee("Иванов Иван Иванович", 1, 50_000) ;
            fullName[1] = new Employee("Петров Петр Петрович", 2, 55_000) ;
            fullName[2] = new Employee("Сидоров Сидр Сидорович", 3, 75_500) ;
            fullName[3] = new Employee("Ефимова Алла Николаевна", 4, 81_500) ;
            fullName[4] = new Employee("Москвин Анатолий Борисович", 5, 92_000) ;
            fullName[5] = new Employee("Фомина Наталья Аркадьевна", 1, 32_000) ;
            fullName[6] = new Employee("Лебедева Оксана Федоровна", 2, 28_200) ;
            fullName[7] = new Employee("Миронова Оксана Владимировна", 3, 68_400) ;
            fullName[8] = new Employee("Васин Василий Антонович", 4, 27_900) ;
            fullName[9] = new Employee("Симонов Семен Васильевич", 5, 88_000) ;

            print() ;
            }

        public static void print() {
            for (Employee employee : fullName) {
                System.out.println(employee);
            }
        }

}