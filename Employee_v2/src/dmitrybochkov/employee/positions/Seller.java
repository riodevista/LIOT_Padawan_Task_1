package dmitrybochkov.employee.positions;

import dmitrybochkov.employee.Month;

public class Seller extends Employee implements IEmployeePosition {

    int extraPremium;
    int checkage;

    public Seller(String name, String surname) {
        super(name, surname);
        setPositionName();
    }

    public Seller(String name, String surname, int basicSalary) {
        super(name, surname, basicSalary);
        setPositionName();
    }

    public Seller(String name, String surname, int basicSalary, int premium) {
        super(name, surname, basicSalary, premium);
        setPositionName();
    }

    private void setPositionName(){
        positionName = "Seller";
    }

    @Override
    public int getSalary(Month month) {
        int salary = basicSalary;

        if(extraPremium != 0){
            salary += extraPremium;
            extraPremium = 0;
        }

        //Делаем вычет из зп, если есть в этом месяце.
        if(checkage != 0){
            salary -= checkage;
            checkage = 0;
        }

        return salary;
    }

    @Override
    public void addCheckage(int value) {
        checkage += value;
    }

    @Override
    public void addPremium(int value) {
        extraPremium += value;
    }

}
