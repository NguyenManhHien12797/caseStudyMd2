package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class UserManager<E> implements Serializable {
    private final String PATH_FILE_USER = "user.dat";
    private final String PATH_FILE_ACCOUNT_USER= "account_user.data";
    private ArrayList<E> usersList;

    private final IOFile<E> ioFileBinary = new IOFileBinary<E>() {
};

    public UserManager() throws IOException {
        File file = new File(PATH_FILE_USER);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            usersList = new ArrayList<>();
        } else {
            usersList = ioFileBinary.readFile(PATH_FILE_USER);
        }
    }

    public void addUser(E e){
        usersList.add(e);
        ioFileBinary.writeFile(PATH_FILE_USER,usersList);
    }

    public void displayUser(){
        usersList = ioFileBinary.readFile(PATH_FILE_USER);
        if(usersList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            usersList.forEach(System.out::println);
        }
    }
}
