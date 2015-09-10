package dmitrybochkov.filesystem.chainOfResp;

import dmitrybochkov.filesystem.Node;


public class ReadAccess extends Access {
    public ReadAccess(int mask){
        this.mask = mask;
    }
    @Override
    protected void accessed(Node node) {
        System.out.println("Readable");
    }
}
