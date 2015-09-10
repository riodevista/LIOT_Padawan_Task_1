package dmitrybochkov.filesystem.chainOfResp;

import dmitrybochkov.filesystem.Node;

public class WriteAccess extends Access {
    public WriteAccess(int mask){
        this.mask = mask;
    }
    @Override
    protected void accessed(Node node) {
        System.out.println("Writable");
    }
}
