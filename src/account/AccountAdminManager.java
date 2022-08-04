package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class AccountAdminManager implements Manager {
    private static final String PATH_FILE_ACCOUNT_ADMIN = "fileData/account_admin.dat";
    private ArrayList<AccountAdmin> accountAdminList;
    private final IOFile<AccountAdmin> ioFileBinary = IOFileBinary.getInstance();

    private static AccountAdminManager instance = null;

    public void AccountAdmin() {
        accountAdminList.add(new AccountAdmin("ADMIN1", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN2", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN3", "123456"));
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_ADMIN, accountAdminList);
    }

    private AccountAdminManager(String path) throws IOException {
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

    public static AccountAdminManager getInstance() throws IOException {
        if (instance == null) instance = new AccountAdminManager(PATH_FILE_ACCOUNT_ADMIN);
        return instance;
    }

    @Override
    public void add(Object o) {
        accountAdminList.add((AccountAdmin) o);
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_ADMIN, accountAdminList);
    }

    @Override
    public void edit(Object o) {

    }

    @Override
    public void remove(String str) {
        accountAdminList.removeIf(p -> p.getAccountAdmin().equals(str));
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_ADMIN, accountAdminList);
    }

    @Override
    public void removeAll() {
        accountAdminList.clear();
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_ADMIN, accountAdminList);
    }

    @Override
    public void display() {
        accountAdminList = ioFileBinary.readFile(PATH_FILE_ACCOUNT_ADMIN);
        if (accountAdminList.isEmpty()) {
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        } else {
            accountAdminList.forEach(System.out::println);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public ArrayList<AccountAdmin> getAccountAdminList() {
        return accountAdminList;
    }

}
