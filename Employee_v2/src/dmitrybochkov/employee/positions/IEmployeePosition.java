package dmitrybochkov.employee.positions;

import dmitrybochkov.employee.Month;



interface IEmployeePosition {
    int getSalary(Month month);
    void addCheckage(int value);
    void addPremium(int value);
}
