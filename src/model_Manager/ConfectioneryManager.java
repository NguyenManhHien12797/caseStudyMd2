package model_Manager;

import account.AccountUser;
import account.User;
import model.Confectionery;
import model.Product;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ConfectioneryManager implements Serializable,IManager{
    private final String PATH_CONFECTIONERY= "confectionery.dat";
    private ArrayList<Confectionery> confectionerytList;
    private final IOFile<Confectionery> ioFileBinary= IOFileBinary.getInstance();
    {
    };

    public ConfectioneryManager(String path) throws IOException{
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            confectionerytList = new ArrayList<>();
        } else {
            confectionerytList = ioFileBinary.readFile(path);
        }
    }
    @Override
    public void display() {
        confectionerytList = ioFileBinary.readFile(PATH_CONFECTIONERY);
        if(confectionerytList.isEmpty()){
            System.out.println("Chưa có sản phẩm nào!");
        }else {
            confectionerytList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        confectionerytList.removeIf(p -> p.getId()==(id));
        ioFileBinary.writeFile(PATH_CONFECTIONERY,confectionerytList);
    }

    @Override
    public void deleteAll() {
        confectionerytList.clear();
        ioFileBinary.writeFile(PATH_CONFECTIONERY,confectionerytList);
    }

    @Override
    public void add(Object o) {
        confectionerytList.add((Confectionery) o);
        ioFileBinary.writeFile(PATH_CONFECTIONERY,confectionerytList);
    }

    @Override
    public void editName(int id, String editName) {
    for(Product p: confectionerytList){
        if(p.getId()==id){
            p.setName(editName);
        }
    }
    }

    @Override
    public void editPrice(int id, double price) {
    for(Product p: confectionerytList){
        if(p.getId()==id){
            p.setPrice(price);
        }
    }
    }

    @Override
    public void editBrand(int id, String brand) {
        for(Product p: confectionerytList){
            if(p.getId()==id){
                p.setBrand(brand);
            }
        }
    }
}
