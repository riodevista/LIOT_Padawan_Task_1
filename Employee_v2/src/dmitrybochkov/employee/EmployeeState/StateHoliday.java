package dmitrybochkov.employee.EmployeeState;


import dmitrybochkov.employee.Employee;

public class StateHoliday extends State {
    @Override
    public int getSalary(Employee employee){
        return 0; //Каникулы за свой счёт.
    }
}
