package dmitrybochkov.employee;

import dmitrybochkov.employee.positions.Director;
import dmitrybochkov.employee.positions.Employee;
import dmitrybochkov.employee.positions.Manager;
import dmitrybochkov.employee.positions.Seller;

import java.util.ArrayList;

/*
    Я решил, что это будет такой адаптер между контейнером и непосредственно пользователем.
 */
public class EmployeesManager {

    private static Month currentMonth;

    public static void inputOneEmployee(ArrayList<Employee> employees){
        Employee newEmployee = null;

        System.out.println("New Employee...");

        System.out.print("Name: ");
        String name = System.console().readLine(); //Только в консоли работает.

        System.out.print("\nSurname: ");
        String surname = System.console().readLine();

        System.out.print("Enter number for position:\n" +
                "1.Director\n" +
                "2.Manager\n" +
                "3.Seller\n");
        String position = System.console().readLine();

        switch (position){
            case "1":
                newEmployee = new Director(name, surname);
                break;
            case "2":
                newEmployee = new Manager(name, surname);
                break;
            case "3":
                newEmployee = new Seller(name, surname);
                break;
            default:
                break;
        }

        int basicSalary = 0;
        System.out.print("\nBasic Salary: ");
        String s = System.console().readLine();
        try {
            basicSalary = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }

        int premium = 0;
        System.out.print("\nPremium: ");
        s = System.console().readLine();
        try {
            basicSalary = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }



        if (newEmployee != null)
            newEmployee.setBasicSalary(basicSalary);
            newEmployee.setPremium(premium);
            employees.add(newEmployee);
    }

    private static void outputEmployee(Employee employee){
        System.out.println(
                employee.getName() + " "
                        + employee.getSurname() + " "
                        + employee.getPositionName() + " "
                        + employee.getSalary(currentMonth));
    }

    public static void outputAllEmployees(ArrayList<Employee> employees){
        for(Employee employee : employees){
            outputEmployee(employee);
        }
    }

    public static void showByPosition(ArrayList<Employee> employees, String position){
        for(Employee employee : employees){
            if(employee.getPositionName().equals(position)){
                outputEmployee(employee);
            }
        }
    }

    public static Month getCurrentMonth(){
        return currentMonth;
    }

    public static void setCurrentMonth(Month month){
        currentMonth = month;
    }

}
