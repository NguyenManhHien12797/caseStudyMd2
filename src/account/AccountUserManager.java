 package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AccountUserManager implements Manager{
    private ArrayList<AccountUser> accountList;
    private final IOFile<AccountUser> ioFileBinary = new IOFileBinary<>();

    public AccountUserManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            accountList = new ArrayList<>();
        } else {
            accountList = ioFileBinary.readFile(path);
        }
    }
    @Override
    public void add(Object o, String path) {
        accountList.add((AccountUser) o);
        ioFileBinary.writeFile(path,accountList);
    }

    @Override
    public void edit(Object o, String path) {

    }

    @Override
    public void remove(String str, String path) {
        accountList.removeIf(p -> p.getAccount().equals(str));
        ioFileBinary.writeFile(path,accountList);
    }

    @Override
    public void removeAll(String path) {
        accountList.clear();
        ioFileBinary.writeFile(path,accountList);
    }

    @Override
    public void display(String path) {
        accountList = ioFileBinary.readFile(path);
        if(accountList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            accountList.forEach(System.out::println);
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
