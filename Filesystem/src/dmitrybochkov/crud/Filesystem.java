package dmitrybochkov.crud;

public class Filesystem {

    private static final String ROOT_DIR_NAME = "root";

    private final Directory root = new Directory(ROOT_DIR_NAME, ROOT_DIR_NAME);

    public Filesystem(){

    }

    public void create(String path, IFilesystemItem item){
        IDirectory dirToCreate = (IDirectory) getItem(path);
        //Можно реализовать создание несуществующих директорий к файлу, но суть ведь в интерфейсах, а не в алгоритмах.
        if(dirToCreate != null){
            dirToCreate.getContent().put(item.getName(), item);
        }

    }

    public IFilesystemItem read(String path){
        return getItem(path);
    }

    public void update(String path, IFilesystemItem item){
        IFilesystemItem itemToUpdate = getItem(path);
        if(itemToUpdate == null)
            return;
        IDirectory parentDir = (IDirectory) getItem(path.substring(path.lastIndexOf("/"), path.length()));
        if(itemToUpdate.getClass() == item.getClass()){
            parentDir.getContent().remove(itemToUpdate.getName()); //Удаляем старый
            parentDir.getContent().put(item.getName(), item); //Перемещаем новый
        }
    }

    public void delete(String path){
        IFilesystemItem itemToDelete = getItem(path);
        if(itemToDelete == null || itemToDelete == root)
            return;
        IDirectory parentDir = (IDirectory) getItem(path.substring(path.lastIndexOf("/"), path.length())); //Если в конце будет /, то не сработает :с
        parentDir.getContent().remove(itemToDelete.getName());
    }

    private IFilesystemItem getItem(String path){
        IDirectory currentDir = root;
        IFilesystemItem currentItem = root;

        if(!ROOT_DIR_NAME.equals(path.substring(0, path.indexOf("/")))){
            return null;
        }
        else{
            do{
                path = path.substring(path.indexOf("/") + 1, path.length());
                //Если то был конец пути, то возвращаем, что уже есть.
                if(path.equals("")){
                    return currentItem;
                }
                else{
                    String currentName = path.substring(0, path.indexOf("/"));
                        currentItem = currentDir.getContent().get(currentName);
                        if(currentItem == null){
                            return null;
                        }
                        else{
                            if(currentItem instanceof IDirectory){
                                currentDir = (IDirectory) currentItem;
                            }
                            else if(currentItem instanceof IFile){
                                return currentItem;
                            }
                        }
                }
            }
            while(path.contains("/"));
        }
        return currentItem;
    }

}
