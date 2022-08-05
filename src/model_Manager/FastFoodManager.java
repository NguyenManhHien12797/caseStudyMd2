package model_Manager;

import model.Confectionery;
import model.FastFood;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FastFoodManager implements IManager<FastFood>{

    private final String PATH_FASTFOOD= "fileData/fastfood.dat";
    private ArrayList<FastFood> fastFoodsList;
    private final IOFile<FastFood> ioFileBinary= IOFileBinary.getInstance();
    private static FastFoodManager instance = null;

    private FastFoodManager() throws IOException{
        File file = new File(PATH_FASTFOOD);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            fastFoodsList = new ArrayList<>();
        } else {
            fastFoodsList = ioFileBinary.readFile(PATH_FASTFOOD);
        }
    }
    public static FastFoodManager getInstance() throws IOException{
        if(instance ==null) instance = new FastFoodManager();
        return instance;
    }

    @Override
    public void display() {
        fastFoodsList = ioFileBinary.readFile(PATH_FASTFOOD);
        if(fastFoodsList.isEmpty()){
            System.out.println("Chưa có sản phẩm nào!");
        }else {
            fastFoodsList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        fastFoodsList.removeIf(p -> p.getId()==id);
        ioFileBinary.writeFile(PATH_FASTFOOD,fastFoodsList);
    }

    @Override
    public void deleteAll() {
        fastFoodsList.clear();
        ioFileBinary.writeFile(PATH_FASTFOOD,fastFoodsList);
    }

    @Override
    public void add(FastFood o) {
        fastFoodsList.add(o);
        ioFileBinary.writeFile(PATH_FASTFOOD,fastFoodsList);
    }

    @Override
    public void editName(int id, String editName) {
        for (FastFood p : fastFoodsList) {
            if (p.getId() == id) {
                p.setName(editName);
            }
        }
    }

    @Override
    public void editPrice(int id, double price) {
        for (FastFood p : fastFoodsList) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
    }

    @Override
    public void editBrand(int id, String brand) {
        for (FastFood p : fastFoodsList) {
            if (p.getId() == id) {
                p.setBrand(brand);
            }
        }
    }
    public int size() {
        return fastFoodsList.size();
    }

    public ArrayList<FastFood> getFastFoodsList() {
        return fastFoodsList;
    }
}
