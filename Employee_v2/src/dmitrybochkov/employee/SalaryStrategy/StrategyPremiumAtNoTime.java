package dmitrybochkov.employee.SalaryStrategy;

import dmitrybochkov.employee.Month;


public class StrategyPremiumAtNoTime implements Strategy {
    @Override
    public int getPremium(int premium, Month month) {
        return 0;
    }
}
