package dmitrybochkov.filesystem;


import dmitrybochkov.filesystem.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/* Composite */
public class Directory implements Node {

    private String name;
    private int access;

    private List<Node> childNodes = new ArrayList<>();



    public Directory(){
        this(Node.NONAME);
    }

    public Directory(String name){
        this.name = name;
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
    public int getAccess() {
        return access;
    }

    @Override
    public Node getChild(int n) {
        if(childNodes.size() >= n)
            return null;
        else
            return childNodes.get(n);
    }

    @Override
    public void adopt(Node node) {
        childNodes.add(node);
    }

    @Override
    public void orphan(Node node) {
        //Проверяем, есть ли уже потомок с таким именем
        for(Node childNode : childNodes){
            if(childNode.getName().equals(node.getName()))
                return;
        }

    }

    @Override
    public void accept(Visitor v){
        v.visitDirectory(this);
    }
}
