package dmitrybochkov.filesystem.chainOfResp;


import dmitrybochkov.filesystem.Node;

public abstract class Access {
    public static final int READ = 3;
    public static final int WRITE = 7;
    public static final int EXEC = 9;
    protected int mask;

    protected Access next;

    public Access setNext(Access access){
        next = access;
        return access;
    }

    public void checkAccess(Node node, int access){
        if(access <= mask){
            accessed(node);
        }
        if(next != null){
            next.checkAccess(node, access);
        }
    }

    abstract protected void accessed(Node node);
}
