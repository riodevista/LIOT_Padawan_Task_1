package dmitrybochkov.employee;


import java.util.Comparator;

public class Employee{
    public final static int UNDEFINED_POSITION = -1;
    public final static int UNDEFINED_SALARY = -1;

    //Я не знаю, куда лучше поместить следующие константы:
    public final static int POSITION_1 = 1;
    public final static int POSITION_2 = 2;
    public final static int POSITION_3 = 3;
    /*
    Я решил сделать должности именно через константы, ибо это удобнее для программиста.
    В будущем необходимо реализовать пул позиций. То есть если тетка в офисе вводит несуществующую,
    то надо создавать новую (при этом проверив, не опечаталась ли она: может, она имела в виду уже
    существующую должность).
    С другой стороны: должности в компании обговариваются заранее и не так часто вводятся, так что
    не проблема дя программиста их вручную дописывать, я думаю.
    Зато это помогает избежать всяких несостыковок в базе (те же опечатки и их последствия при поиске).
     */

    private String name;
    private String surname;
    private int position;
    private int salary; //Предположим, что зарплата в целых числах и не в белорусских рублях.

    Employee(final String name, final String surname, final int position, final int salary){
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    Employee(final String name, final String surname){
        this(name, surname, UNDEFINED_POSITION, UNDEFINED_SALARY);
    }

    //Можно ещё предусмотреть разные ситуации, мол, фамилии у человека нет, но не суть.

    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSurname(final String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }

    public void setPosition(final int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }

    public void setSalary(final int salary){
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }


    public static Comparator<Employee> COMPARE_BY_SURNAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.surname.compareTo(other.surname); //Можно задать свою сортировку.
        }
    };

    public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return Integer.compare(one.salary, other.salary);
        }
    };

}
