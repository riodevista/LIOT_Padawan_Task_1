package dmitrybochkov.employee;


import dmitrybochkov.employee.EmployeeState.State;
import dmitrybochkov.employee.EmployeeState.StateAtWork;
import dmitrybochkov.employee.EmployeeState.StateHoliday;
import dmitrybochkov.employee.SalaryStrategy.Strategy;
import dmitrybochkov.employee.SalaryStrategy.StrategyPremiumAtLastMonthOfYear;
import dmitrybochkov.employee.SalaryStrategy.StrategyPremiumAtNoTime;
import dmitrybochkov.employee.SalaryStrategy.StrategyPremiumEveryMonth;
import dmitrybochkov.employee.positions.Position;

import java.util.Comparator;

public class Employee {
    private String name;
    private String surname;
    private Position position;

    private int basicSalary;
    private int premium;
    private int checkage;

    private Strategy premiumStrategy;

    State state;


    //Builder:

    public static class Builder{
        private String name;
        private String surname;
        private Position position;

        private int basicSalary = 0;
        private int premium = 0;
        private int checkage = 0;

        private Strategy premiumStrategy;


        public Builder(String name, String surname, Position position){
            this.name = name;
            this.surname = surname;
            this.position = position;
            premiumStrategy = new StrategyPremiumAtNoTime();
        }

        public Builder basicSalary(int val){
            this.basicSalary = val;
            return this;
        }

        public Builder premiumEveryMonth(int premium){
            this.premium = premium;
            premiumStrategy = new StrategyPremiumEveryMonth();
            return this;
        }

        public Builder premiumAtLastMonthOfYear(int premium){
            this.premium = premium;
            premiumStrategy = new StrategyPremiumAtLastMonthOfYear();
            return this;
        }

        public Builder premiumAtNoTime(){
            this.premium = 0;
            premiumStrategy = new StrategyPremiumAtNoTime();
            return this;
        }

    }

    private Employee(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.position = builder.position;
        this.basicSalary = builder.basicSalary;
        this.premium = builder.premium;
    }


    //Getters and setters:

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setBasicSalary(int basicSalary){
        this.basicSalary = basicSalary;
    }

    public int getBasicSalary(){
        return basicSalary;
    }

    public void setPremium(int premium){
        this.premium = premium;
    }

    public void setCheckage(int checkage){
        this.checkage = checkage;
    }

    public int getSalary(Month month){
        int current = state.getSalary(this); //Неточность в том, что если сотрудник в отпуске, то премию он всё равно получит.

        current += premiumStrategy.getPremium(premium, month); //Strategy

        current -= checkage;
        checkage = 0;

        return current;
    }



    //Strategy:

    public void setSalaryStrategy(Strategy strategy){
        this.premiumStrategy = strategy;
    }


    //State:

    public void setHoliday(){
        this.state = new StateHoliday();
    }

    public void setAtWork(){
        this.state = new StateAtWork();
    }



    //Comparators:

    public static Comparator<Employee> COMPARE_BY_SURNAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.surname.compareTo(other.surname); //Можно задать свою сортировку.
        }
    };

    public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return Integer.compare(one.getSalary(EmployeesManager.getCurrentMonth()),
                    other.getSalary(EmployeesManager.getCurrentMonth()));
        }
    };
}


