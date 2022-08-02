package storerage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileBinary<E> implements Serializable {
    public void writeFile(String path, List<E> o){
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

    public List<E> readFile(String path) {
        List<E> o = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            o = (List<E>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return o;
    }
}
