package dmitrybochkov.filesystem.visitor;

import dmitrybochkov.filesystem.Directory;
import dmitrybochkov.filesystem.File;

public interface Visitor {
    void visitFile(File file);
    void visitDirectory(Directory dir);
}
