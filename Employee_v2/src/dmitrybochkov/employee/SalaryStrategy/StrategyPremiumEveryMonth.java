package dmitrybochkov.employee.SalaryStrategy;

import dmitrybochkov.employee.Month;


public class StrategyPremiumEveryMonth implements Strategy {

    @Override
    public int getPremium(int premium, Month month) {
        return premium;
    }
}
