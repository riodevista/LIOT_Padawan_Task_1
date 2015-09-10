package dmitrybochkov.filesystem;


import dmitrybochkov.filesystem.visitor.Visitor;

/* Component */
public interface Node {
    String NONAME = "Noname";

    String getName();
    void setName(String name);

    int getAccess();

    Node getChild(int n);

    void adopt(Node node);
    void orphan(Node node);

    void accept(Visitor v);
}
