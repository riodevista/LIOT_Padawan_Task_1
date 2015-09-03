package dmitrybochkov.employee;


class Main {
    public static void main(String[] args) {

        EmployeesContainer employeesContainer = new EmployeesContainer();

        for(int i = 0; i < 4; ++i) {
            EmployeesManager.inputOneEmployee(employeesContainer);
        }
        System.out.print("\n");

        EmployeesManager.outputAllEmployees(employeesContainer);
        System.out.print("\n");

        employeesContainer.sort(EmployeesContainer.KEY_SALARY);

        EmployeesManager.outputAllEmployees(employeesContainer);
        System.out.print("\n");

        employeesContainer.sort(EmployeesContainer.KEY_SURNAME);

        EmployeesManager.outputAllEmployees(employeesContainer);
        System.out.print("\n");

    }
}