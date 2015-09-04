package dmitrybochkov.crud;

import java.util.HashMap;

public interface IDirectory {
    HashMap<String, IFilesystemItem> getContent();
}
