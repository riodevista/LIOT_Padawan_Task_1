package dmitrybochkov.employee.positions;


import dmitrybochkov.employee.Month;

public class Director extends Employee implements IEmployeePosition {

    public Director(String name, String surname) {
        super(name, surname);
        setPositionName();
    }

    public Director(String name, String surname, int basicSalary) {
        super(name, surname, basicSalary);
        setPositionName();
    }

    public Director(String name, String surname, int basicSalary, int premium) {
        super(name, surname, basicSalary, premium);
        setPositionName();
    }

    public void setPositionName() {
        positionName = "Director";
    }

    @Override
    public int getSalary(Month month) {
        int salary = basicSalary;

        salary += premium;

        return salary;
    }

    @Override
    public void addCheckage(int value) {
        //Нельзя сделать вычеты директору.
    }

    @Override
    public void addPremium(int value) {
        //Директор и так получает каждый месяц премию.
    }



}
