package dmitrybochkov.employee;


import java.util.Comparator;

public class Employee{
    public final static int UNDEFINED_POSITION = -1;
    public final static int UNDEFINED_SALARY = -1;

    //� �� ����, ���� ����� ��������� ��������� ���������:
    public final static int POSITION_1 = 1;
    public final static int POSITION_2 = 2;
    public final static int POSITION_3 = 3;
    /*
    � ����� ������� ��������� ������ ����� ���������, ��� ��� ������� ��� ������������.
    � ������� ���������� ����������� ��� �������. �� ���� ���� ����� � ����� ������ ��������������,
    �� ���� ��������� ����� (��� ���� ��������, �� ����������� �� ���: �����, ��� ����� � ���� ���
    ������������ ���������).
    � ������ �������: ��������� � �������� �������������� ������� � �� ��� ����� ��������, ��� ���
    �� �������� �� ������������ �� ������� ����������, � �����.
    ���� ��� �������� �������� ������ ������������ � ���� (�� �� �������� � �� ����������� ��� ������).
     */

    private String name;
    private String surname;
    private int position;
    private int salary; //�����������, ��� �������� � ����� ������ � �� � ����������� ������.

    Employee(final String name, final String surname, final int position, final int salary){
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }

    Employee(final String name, final String surname){
        this(name, surname, UNDEFINED_POSITION, UNDEFINED_SALARY);
    }

    //����� ��� ������������� ������ ��������, ���, ������� � �������� ���, �� �� ����.

    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSurname(final String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }

    public void setPosition(final int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }

    public void setSalary(final int salary){
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }


    public static Comparator<Employee> COMPARE_BY_SURNAME = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return one.surname.compareTo(other.surname); //����� ������ ���� ����������.
        }
    };

    public static Comparator<Employee> COMPARE_BY_SALARY = new Comparator<Employee>() {
        public int compare(Employee one, Employee other) {
            return Integer.compare(one.salary, other.salary);
        }
    };

}
