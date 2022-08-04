package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class UserManager implements Serializable, Manager {
    private static final String PATH_FILE_USER = "fileData/user.dat";

    private ArrayList<User> usersList;

    //Sử dụng Singleton pattern để tạo đối tượng UserManager duy nhất

    private static UserManager instance = null;


    private final IOFile<User> ioFileBinary= IOFileBinary.getInstance();{
};

    private UserManager(String path) throws IOException {
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

    public static UserManager getInstance() throws IOException {
        if(instance == null) instance =new UserManager(PATH_FILE_USER);
        return instance;
    }



    public int size(){
       return usersList.size();
    }

    @Override
    public void add(Object o) {

        usersList.add((User) o);
        ioFileBinary.writeFile(PATH_FILE_USER,usersList);
    }

    @Override
    public void edit(Object o) {

    }

    @Override
    public void remove(String str) {
        usersList.removeIf(p -> p.getId().equals(str));
        ioFileBinary.writeFile(PATH_FILE_USER,usersList);
    }

    @Override
    public void removeAll() {
        usersList.clear();
       ioFileBinary.writeFile(PATH_FILE_USER,usersList);

    }

    public void display( ){
        usersList = ioFileBinary.readFile(PATH_FILE_USER);
        if(usersList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            usersList.forEach(System.out::println);
        }
    }
}
