package model_Manager;

import model.Confectionery;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CartManager {
    private final String PATH_USERCART = "fileData/usercart.dat";
    private ArrayList<CartManager> cartManagersList;
    private final IOFile<CartManager> ioFileBinary = IOFileBinary.getInstance();

    private static CartManager instance = null;
    private  CartManager() throws IOException {
        File file = new File(PATH_USERCART);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            cartManagersList = new ArrayList<>();
        } else {
            cartManagersList = ioFileBinary.readFile(PATH_USERCART);
        }
    }

    public static CartManager getInstance() throws IOException {
        if (instance == null) instance = new CartManager();
        return instance;
    }
    public void display() {
        cartManagersList = ioFileBinary.readFile(PATH_USERCART);
        if (cartManagersList.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào!");
        } else {
            cartManagersList.forEach(System.out::println);
        }
    }
    public void deleteAll() {
        cartManagersList.clear();
        ioFileBinary.writeFile(PATH_USERCART, cartManagersList);
    }
    public void add(CartManager o) {
        cartManagersList.add(o);
        ioFileBinary.writeFile(PATH_USERCART, cartManagersList);
    }


}
