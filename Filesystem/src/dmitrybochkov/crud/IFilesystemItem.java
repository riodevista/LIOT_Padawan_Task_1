package dmitrybochkov.crud;

/**
 * Created by Riodevista on 03.09.2015.
 */
public interface IFilesystemItem {
    String getName();
    void setName(String name);

    String getPath(); //� ���� ������� �� ����� ������ � ������������ ����������� ��������.
    void setPath(String path);

    int getSize();
}
