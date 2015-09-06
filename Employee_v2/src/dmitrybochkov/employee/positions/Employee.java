package dmitrybochkov.employee.positions;


import dmitrybochkov.employee.EmployeesManager;
import dmitrybochkov.employee.Month;

import java.util.Comparator;

public abstract class Employee{

    protected String name;
    protected String surname;
    protected int basicSalary; //Предположим, что зарплата в целых числах и не в белорусских рублях.
    protected int premium;
    protected String positionName;

    Employee(String name, String surname){
        this(name, surname, 0, 0);
    }

    Employee(String name, String surname, int basicSalary){
        this(name, surname, basicSalary, 0);
    }

    Employee(String name, String surname, int basicSalary, int premium){
        this.name = name;
        this.surname = surname;
        this.basicSalary = basicSalary;
        this.premium = premium;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setBasicSalary(int basicSalary){
        this.basicSalary = basicSalary;
    }

    public void setPremium(int premium){
        this.premium = premium;
    }

    public abstract int getSalary(Month month);

    public String getPositionName(){
        return positionName;
    }

   public static Comparator<Employee> COMPARE_BY_SURNAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.surname.compareTo(other.surname); //Можно задать свою сортировку.
        }
    };

    public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return Integer.compare(one.getSalary(EmployeesManager.getCurrentMonth()),
                                   other.getSalary(EmployeesManager.getCurrentMonth()));
        }
    };
}
