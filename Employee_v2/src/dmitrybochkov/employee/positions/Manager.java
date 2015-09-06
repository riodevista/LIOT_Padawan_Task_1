package dmitrybochkov.employee.positions;


import dmitrybochkov.employee.Month;

public class Manager extends Employee implements IEmployeePosition {

    int extraPremium;

    public Manager(String name, String surname) {
        super(name, surname);
        setPositionName();
    }

    public Manager(String name, String surname, int basicSalary) {
        super(name, surname, basicSalary);
        setPositionName();
    }

    public Manager(String name, String surname, int basicSalary, int premium) {
        super(name, surname, basicSalary, premium);
        setPositionName();
    }

    private void setPositionName(){
        positionName = "Manager";
    }

    @Override
    public int getSalary(Month month) {
        int salary = basicSalary;

        if (month == Month.DECEMBER) {
            salary += premium;
        }

        //Выплачиваем надбавку в этом месяце, если есть.
        if(extraPremium != 0){
            salary += extraPremium;
            extraPremium = 0;
        }

        return salary;
    }

    @Override
    public void addCheckage(int value) {

    }

    @Override
    public void addPremium(int value) {
        extraPremium += value;
    }

}