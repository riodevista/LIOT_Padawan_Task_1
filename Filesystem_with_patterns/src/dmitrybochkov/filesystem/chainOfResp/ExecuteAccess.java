package dmitrybochkov.filesystem.chainOfResp;

import dmitrybochkov.filesystem.Node;


public class ExecuteAccess extends Access {
    public ExecuteAccess(int mask){
        this.mask = mask;
    }
    @Override
    protected void accessed(Node node) {
        System.out.println("Executable");
    }
}
