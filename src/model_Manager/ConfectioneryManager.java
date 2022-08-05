package model_Manager;

import model.Confectionery;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConfectioneryManager implements IManager<Confectionery> {
    private final String PATH_CONFECTIONERY = "fileData/confectionery.dat";
    private ArrayList<Confectionery> confectionerytList;
    private final IOFile<Confectionery> ioFileBinary = IOFileBinary.getInstance();


    private static ConfectioneryManager instance = null;

    private ConfectioneryManager() throws IOException {
        File file = new File(PATH_CONFECTIONERY);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            confectionerytList = new ArrayList<>();
        } else {
            confectionerytList = ioFileBinary.readFile(PATH_CONFECTIONERY);
        }
    }

    public static ConfectioneryManager getInstance() throws IOException {
        if (instance == null) instance = new ConfectioneryManager();
        return instance;
    }

    @Override
    public void display() {
        confectionerytList = ioFileBinary.readFile(PATH_CONFECTIONERY);
        if (confectionerytList.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
        } else {
            confectionerytList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        confectionerytList.removeIf(p -> p.getId() == id);
        ioFileBinary.writeFile(PATH_CONFECTIONERY, confectionerytList);
    }

    @Override
    public void deleteAll() {
        confectionerytList.clear();
        ioFileBinary.writeFile(PATH_CONFECTIONERY, confectionerytList);
    }

    @Override
    public void add(Confectionery o) {
        confectionerytList.add(o);
        ioFileBinary.writeFile(PATH_CONFECTIONERY, confectionerytList);
    }

    @Override
    public void editName(int id, String editName) {
        for (Confectionery p : confectionerytList) {
            if (p.getId() == id) {
                p.setName(editName);
            }
        }
    }

    @Override
    public void editPrice(int id, double price) {
        for (Confectionery p : confectionerytList) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Confectionery p : confectionerytList) {
            if (p.getId() == id) {
                p.setBrand(brand);
            }
        }
    }


    public int size() {
        return confectionerytList.size();
    }

    public ArrayList<Confectionery> getConfectionerytList() {
        return confectionerytList;
    }
}
