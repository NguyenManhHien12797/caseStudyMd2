package model_Manager;

import account.UserManager;
import model.Product;
import model.Vietlott;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VietlottManager implements IManager<Vietlott> {
    private static final String PATH_VIETLOTT = "fileData/vietlott.dat";
    private ArrayList<Vietlott> vietlottsList;
    private static VietlottManager instance = null;

    private final IOFile<Vietlott> ioFileBinary = IOFileBinary.getInstance();

    private VietlottManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            vietlottsList = new ArrayList<>();
        } else {
            vietlottsList = ioFileBinary.readFile(path);
        }
    }

    public static VietlottManager getInstance() throws IOException {
        if (instance == null) instance = new VietlottManager(PATH_VIETLOTT);
        return instance;
    }

    public int size() {
        return vietlottsList.size();
    }

    @Override
    public void display() {
        vietlottsList = ioFileBinary.readFile(PATH_VIETLOTT);
        if (vietlottsList.isEmpty()) {
            System.out.println("Chưa có thông tin người nào đăng ký!");
        } else {
            vietlottsList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        vietlottsList.removeIf(p -> p.getId() == id);
        ioFileBinary.writeFile(PATH_VIETLOTT, vietlottsList);
    }

    @Override
    public void deleteAll() {
        vietlottsList.clear();
        ioFileBinary.writeFile(PATH_VIETLOTT, vietlottsList);
    }

    @Override
    public void add(Vietlott o) {
        vietlottsList.add(o);
        ioFileBinary.writeFile(PATH_VIETLOTT, vietlottsList);
    }

    @Override
    public void editName(int id, String editName) {
        for (Vietlott p : vietlottsList) {
            if (p.getId() == id) {
                p.setName(editName);
            }
        }
    }
    public void editPrice ( int id, double price){
        for (Vietlott p : vietlottsList) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
    }

    @Override
    public void editBrand(int id, String brand) {
        for(Vietlott p: vietlottsList){
            if(p.getId()==id){
                p.setBrand(brand);
            }
        }
    }

    public ArrayList<Vietlott> getVietlottsList() {
        return vietlottsList;
    }
}
