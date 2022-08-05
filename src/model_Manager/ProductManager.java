package model_Manager;

import model.Confectionery;
import model.Product;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ProductManager implements  IManager {
    private final String PATH_PRODUCT = "fileData/product.dat";
    private ArrayList<Product> productsList;
    private final IOFile<Product> ioFileBinary = IOFileBinary.getInstance();

    private static ProductManager instance = null;

    private ProductManager() throws IOException{
        File file = new File(PATH_PRODUCT);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            productsList = new ArrayList<>();
        } else {
            productsList = ioFileBinary.readFile(PATH_PRODUCT);
        }
    }
    @Override
    public void display() {
        productsList = ioFileBinary.readFile(PATH_PRODUCT);
        if(productsList.isEmpty()){
            System.out.println("Chưa có sản phẩm nào!");
        }else {
            productsList.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        productsList.removeIf(p -> p.getId()==(id));
        ioFileBinary.writeFile(PATH_PRODUCT,productsList);
    }

    @Override
    public void deleteAll() {
        productsList.clear();
        ioFileBinary.writeFile(PATH_PRODUCT,productsList);
    }

    @Override
    public void add(Object o) {
        productsList.add((Product) o);
        ioFileBinary.writeFile(PATH_PRODUCT,productsList);
    }

    @Override
    public void editName(int id, String editName) {
        for (Product p : productsList) {
            if (p.getId() == id) {
                p.setName(editName);
            }
        }


    }


    @Override
    public void editBrand(int id, String brand) {
        for(Product p: productsList){
            if(p.getId()==id){
                p.setBrand(brand);
            }
        }
    }
    @Override
    public void editPrice(int id, double price) {
        for (Product p : productsList) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
    }
}

