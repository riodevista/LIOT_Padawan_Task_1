package dmitrybochkov.crud;

public class File implements IFilesystemItem, IFile {

    private String name;
    private String path;
    private String type;
    private Integer data;

    File(String path, String name){
        this(path, name, null, null);
    }

    File(String path, String name, String type){
        this(path, name, type, null);
    }

    File(String path, String name, String type, Integer data){
        this.path = path;
        this.name = name;
        this.type = type;
        this.data = data;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int getSize() {
        //Как-то рассчитываем по data.
        return 0;
    }
}
