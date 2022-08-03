package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class UserManager implements Serializable, Manager {
    private final String PATH_FILE_USER = "user.dat";
    private final String PATH_FILE_ACCOUNT_USER= "account_user.data";
    private ArrayList<User> usersList;


    private final IOFile<User> ioFileBinary = new IOFileBinary<User>() {
};

    public UserManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            usersList = new ArrayList<>();
        } else {
            usersList = ioFileBinary.readFile(path);
        }
    }



    public int size(){
       return usersList.size();
    }

    @Override
    public void add(Object o, String path) {

        usersList.add((User) o);
        ioFileBinary.writeFile(path,usersList);
    }

    @Override
    public void edit(Object o, String path) {

    }

    @Override
    public void remove(String str, String path) {
        usersList.removeIf(p -> p.getId().equals(str));
        ioFileBinary.writeFile(path,usersList);
    }

    @Override
    public void removeAll(String path) {
        usersList.clear();
       ioFileBinary.writeFile(path,usersList);

    }

    public void display(String path){
        usersList = ioFileBinary.readFile(path);
        if(usersList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            usersList.forEach(System.out::println);
        }
    }
}
