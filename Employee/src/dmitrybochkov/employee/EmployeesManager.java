package dmitrybochkov.employee;


import java.util.ArrayList;

/*
    Я решил, что это будет такой адаптер между контейнером и непосредственно пользователем.
 */
class EmployeesManager {

    public static void inputOneEmployee(final EmployeesContainer employeesContainer){
        System.out.println("New Employee...");

        System.out.print("Name: ");
        String name = System.console().readLine(); //Только в консоли работает.

        System.out.print("/nSurname: ");
        String surname = System.console().readLine();

        System.out.print("Enter number for position:/n" +
                "1.Position1/n" +
                "2.Position2/n" +
                "3.Position3/n");
        String p = System.console().readLine();
        int position = Employee.UNDEFINED_POSITION;
        try {
            position = Integer.parseInt(p);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            //Все сломалось.
        }

        int salary = Employee.UNDEFINED_SALARY;

        if (position != Employee.UNDEFINED_POSITION){
            System.out.print("/nSalary: ");
            String s = System.console().readLine();
            try {
                salary = Integer.parseInt(s);
            }
            catch (NumberFormatException e){
                e.printStackTrace();
                //Снова :ссс
            }
        }


        employeesContainer.add(name, surname, position, salary);
    }

    private static void outputEmployee(final Employee employee){
        //Здесь надо что-то с ресурсами мутить, а то с локализацией проблемы и т.п., не хардкодить ведь.
        String position = "no position";
        switch (employee.getPosition()) { //Надо было сразу список позиций делать, а то это не оч, что я сейчас творю.
            case Employee.POSITION_1:
                position = "Position1";
                break;
            case Employee.POSITION_2:
                position = "Position2";
                break;
            case Employee.POSITION_3:
                position = "Position3";
                break;
            default:
                break;
        }

        System.out.println(
                employee.getName() + " "
                        + employee.getSurname() + " "
                        + position + " "
                        + employee.getSalary());
    }

    public static void outputAllEmployees(final EmployeesContainer employeesContainer){
        for(Employee employee : employeesContainer.getEmployees()){
            outputEmployee(employee);
        }
    }

    public static void showByPosition(final EmployeesContainer employeesContainer, final int position){
        for(Employee employee : employeesContainer.getEmployees()){
            if(employee.getPosition() == position){
                outputEmployee(employee);
            }
        }
    }

}
