package dmitrybochkov.filesystem.visitor;


import dmitrybochkov.filesystem.Directory;
import dmitrybochkov.filesystem.File;

public class Data implements Visitor{
    @Override
    public void visitFile(File file) {
        //Выводим на экран содержимое файла.
    }

    @Override
    public void visitDirectory(Directory dir) {
        //Выводим на экран содержимое каталога.
    }
}
