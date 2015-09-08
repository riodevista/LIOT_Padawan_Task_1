package dmitrybochkov.employee.EmployeeState;

import dmitrybochkov.employee.Employee;


public class StateAtWork extends State {
    @Override
    public int getSalary(Employee employee){
        return employee.getBasicSalary();
    }
}