package dmitrybochkov.employee.SalaryStrategy;

import dmitrybochkov.employee.Month;

/**
 * Created by Riodevista on 08.09.2015.
 */
public class StrategyPremiumAtLastMonthOfYear implements Strategy {
    @Override
    public int getPremium(int premium, Month month) {
        if(month == Month.DECEMBER)
            return premium;
        else
            return 0;
    }
}
