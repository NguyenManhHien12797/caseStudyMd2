package storage;

import java.util.ArrayList;

public interface IOFile<E> {
    void writeFile(String path, ArrayList<E> o);
    ArrayList<E> readFile(String path);

}
