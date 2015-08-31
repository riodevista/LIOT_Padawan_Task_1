package dmitrybochkov.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EmployeesContainer implements IEmployeesContainer{
    private static final int KEY_SURNAME = 1;
    private static final int KEY_SALARY = 2;

    private ArrayList<Employee> employees;

    EmployeesContainer(){
        employees = new ArrayList<>();
    }

    EmployeesContainer(final ArrayList<Employee> employees){
        this.employees = new ArrayList<>(employees);
    }

    EmployeesContainer(final Employee[] employees){
        this. employees = new ArrayList<>(Arrays.asList(employees));
    }

    @Override
    public void add(final String name, final String surname, final int position, final int salary){
        Employee employee = new Employee(name, surname, position, salary);
        employees.add(employee);
    }
    
    public void add(final String name, final String surname){
        Employee employee = new Employee(name, surname);
        employees.add(employee);
    }

    @Override
    public Employee get(final int index){
        return employees.get(index);
    }

    public ArrayList<Employee> getEmployees(){
        return employees; //Отдадим ссылку на сам объект, а не на копию.
    }

    public int size(){
        return employees.size();
    }

    /*Должен ли контейнер сам себя сортировать? В ArrayList есть метод sort, так что последовал
    * по этому пути.
    */
    public void sort(final int key){
        switch (key){
            case KEY_SURNAME:
                Collections.sort(employees, Employee.COMPARE_BY_SURNAME);
                break;
            case KEY_SALARY:
                Collections.sort(employees, Employee.COMPARE_BY_SALARY);
                break;
            default:
                break;
        }
        //Хотя забавно, что я реализовал другим путем, когда сортировка происходит извне :)
    }
}
