package dmitrybochkov.crud;

import java.util.HashMap;

/**
 * Created by Riodevista on 04.09.2015.
 */
public interface IDirectory {
    HashMap<String, IFilesystemItem> getContent();
}
