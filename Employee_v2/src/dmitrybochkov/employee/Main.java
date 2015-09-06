package dmitrybochkov.employee;


import dmitrybochkov.employee.positions.Employee;

import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        for(int i = 0; i < 4; ++i) {
            EmployeesManager.inputOneEmployee(employees);
        }
        System.out.print("\n");
        EmployeesManager.outputAllEmployees(employees);
        System.out.print("\n");


        Collections.sort(employees, Employee.COMPARE_BY_SALARY);
        EmployeesManager.outputAllEmployees(employees);
        System.out.print("\n");


        Collections.sort(employees, Employee.COMPARE_BY_SURNAME);
        EmployeesManager.outputAllEmployees(employees);
        System.out.print("\n");

    }
}