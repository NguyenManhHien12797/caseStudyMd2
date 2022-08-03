package account;

public interface Manager<E> {
    void add(E e,String path);
    void edit(E e,String path);
    void remove(String str,String path);
    void removeAll(String path);


    void display(String path);

    int size();
}
