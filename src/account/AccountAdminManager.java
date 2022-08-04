package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AccountAdminManager implements  Manager{
    private final String PATH_FILE_ACCOUNT_USER= "fileData/account_user.dat";
    private ArrayList<AccountAdmin> accountAdminList;
    private final IOFile<AccountAdmin> ioFileBinary= IOFileBinary.getInstance();

    public void AccountAdmin() {
        accountAdminList.add(new AccountAdmin("ADMIN1", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN2", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN3", "123456"));
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accountAdminList);
    }

    public AccountAdminManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            accountAdminList = new ArrayList<>();
        } else {
            accountAdminList = ioFileBinary.readFile(path);
        }
    }

    @Override
    public void add(Object o) {
        accountAdminList.add((AccountAdmin) o);
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accountAdminList);
    }

    @Override
    public void edit(Object o) {

    }

    @Override
    public void remove(String str) {
        accountAdminList.removeIf(p -> p.getAccountAdmin().equals(str));
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accountAdminList);
    }

    @Override
    public void removeAll() {
        accountAdminList.clear();
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accountAdminList);
    }

    @Override
    public void display() {
        accountAdminList = ioFileBinary.readFile(PATH_FILE_ACCOUNT_USER);
        if(accountAdminList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            accountAdminList.forEach(System.out::println);
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
