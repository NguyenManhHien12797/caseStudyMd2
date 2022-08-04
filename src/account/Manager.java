package account;

import java.util.ArrayList;
import java.util.List;

public interface Manager<E> {
    void add(E e);
    void edit(E e);
    void remove(String str);
    void removeAll();


    void display();

    int size();

}
