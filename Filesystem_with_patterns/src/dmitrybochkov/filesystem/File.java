package dmitrybochkov.filesystem;

import dmitrybochkov.filesystem.observer.Observable;
import dmitrybochkov.filesystem.observer.Observer;
import dmitrybochkov.filesystem.visitor.Visitor;

import java.util.List;

/* Leaf */
public class File implements Node, Observable {

    private String name;
    private Object data;
    private int access;

    private List<Observer> observerList;


    public File(){
        this(Node.NONAME);
    }

    public File(String name){
        this.name = name;
        notifyObservers(); //Уведомили о создании.
    }

    public void setData(Object data){
        this.data = data;
    }

    public Object getData(){
        return data;
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
    public String getName() {
        return name;
    }

    @Override
    public Node getChild(int n) {
        return null;
    }

    @Override
    public void adopt(Node node) {
        //Сообщить об ошибке
    }

    @Override
    public void orphan(Node node) {
        //Сообщить об ошибке
    }


    //Visitor

    @Override
    public void accept(Visitor v){
        v.visitFile(this);
    }


    //Observer

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList)
        {
            observer.update();
        }
    }
}
