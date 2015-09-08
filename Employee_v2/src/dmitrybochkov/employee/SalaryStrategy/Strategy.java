package dmitrybochkov.employee.SalaryStrategy;


import dmitrybochkov.employee.Month;

public interface Strategy {
    int getPremium(int premium, Month month);
}
