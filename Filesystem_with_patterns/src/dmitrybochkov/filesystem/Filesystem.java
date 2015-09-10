package dmitrybochkov.filesystem;

import dmitrybochkov.filesystem.visitor.Data;
import dmitrybochkov.filesystem.chainOfResp.*;

public class Filesystem {
    private static final String sep = "/";

    Directory root = new Directory("root");

    public Filesystem(){

    }

    public Directory getRoot(){
        return root;
    }

    public void read(Node current, String path){
        Node nodeToRead = getItem(current, path);

        nodeToRead.accept(new Data()); //Visitor.
    }


    public Node getItem(Node current, String path){
        String subpath = subpath(path);

            String name = head(path);
            Node child = find(name, current);
            if(child != null){
                getItem(child, subpath);
            } else{
                return null;
            }

        return null;
    }

    public Node find(String name, Node current){
        Node child = null;
        for(int i = 0; (child = current.getChild(i)) != null ; ++i){
            if(name.equals(child.getName()))
                return child;
        }
        return null;
    }

    private String head(String path){
        return path.substring(0, path.indexOf(sep));
    }

    private String subpath(String path){
        return path.substring(path.indexOf(sep) + sep.length(), path.length());
    }


    public void checkAccess(Node node, int access){
        Access readable, writable, executable;

        readable = new ReadAccess(Access.READ);
        writable = readable.setNext(new WriteAccess(Access.WRITE));
        executable = writable.setNext(new ExecuteAccess(Access.EXEC));

        readable.checkAccess(node, access);

    }
}
