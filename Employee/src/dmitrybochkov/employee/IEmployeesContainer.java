package dmitrybochkov.employee;

public interface IEmployeesContainer {
    void add(final String name, final String surname, final int position, final  int salary);
    Employee get(final int index);
}
