package storage;

import java.io.*;
import java.util.ArrayList;

public class IOFileBinary<E> implements IOFile<E> {

    // Sử dụng Singleton design pattern để tạo 1 đối tượng đọc ghi file duy nhất

    private static IOFileBinary instance = null;

    private IOFileBinary(){

    }

    public static IOFileBinary getInstance(){
        if(instance == null) instance = new IOFileBinary();
        return instance;
    }
    public void writeFile(String path, ArrayList<E> o){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<E> readFile(String path) {
       ArrayList<E> o = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o = (ArrayList<E>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return o;
    }
}
