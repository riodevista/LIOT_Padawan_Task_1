package dmitrybochkov.crud;

import java.util.HashMap;

/**
 * Created by Riodevista on 03.09.2015.
 */
public class Directory implements IFilesystemItem, IDirectory{

    private String name;
    private String path;
    private HashMap<String, IFilesystemItem> content;

    Directory(String path, String name){
        this(path, name, new HashMap<>());
    }

    Directory(String path, String name, HashMap<String, IFilesystemItem> content){
        this.path = path;
        this.name = name;
        this.content = content;
    }

    @Override
    public HashMap<String, IFilesystemItem> getContent() {
        return content;
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

    }

    @Override
    public int getSize() {
        //Здесь подсчитываем суммарный вес директории.
        return 0;
    }
}
