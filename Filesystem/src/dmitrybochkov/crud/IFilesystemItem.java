package dmitrybochkov.crud;

public interface IFilesystemItem {
    String getName();
    void setName(String name);

    String getPath(); //И путь неплохо бы через объект с определенным интерфейсом намутить.
    void setPath(String path);

    int getSize();
}
