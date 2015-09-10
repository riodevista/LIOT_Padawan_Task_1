package dmitrybochkov.filesystem.observer;


public class CurrentNumberOfFiles implements Observer {
    @Override
    public void update() {
        //Увеличиваем где-то хранящийся счётчик файлов на 1.
        //counter++;
    }
}
