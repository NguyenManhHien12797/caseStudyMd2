 package account;

import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AccountUserManager implements Manager<AccountUser>{
    private static final String PATH_FILE_ACCOUNT_USER= "fileData/account_user.dat";
    private ArrayList<AccountUser> accounUserstList;
    private final IOFile<AccountUser> ioFileBinary= IOFileBinary.getInstance();

    //Sử dụng Singleton pattern để tạo đối tượng AccountUserManager duy nhất
    private static AccountUserManager instance = null;

    private AccountUserManager(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            accounUserstList = new ArrayList<>();
        } else {
            accounUserstList = ioFileBinary.readFile(path);
        }
    }
    public static AccountUserManager getInstance() throws IOException {
        if(instance == null) instance = new AccountUserManager(PATH_FILE_ACCOUNT_USER);
        return instance;
    }
    @Override
    public void add(AccountUser o) {
        accounUserstList.add( o);
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accounUserstList);
    }

    @Override
    public void edit(AccountUser o) {

    }

    @Override
    public void remove(String str) {
        accounUserstList.removeIf(p -> p.getAccount().equals(str));
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accounUserstList);
    }

    @Override
    public void removeAll() {
        accounUserstList.clear();
        ioFileBinary.writeFile(PATH_FILE_ACCOUNT_USER, accounUserstList);
    }

    @Override
    public void display( ) {
        accounUserstList = ioFileBinary.readFile(PATH_FILE_ACCOUNT_USER);
        if(accounUserstList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký!");
        }else {
            accounUserstList.forEach(System.out::println);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public ArrayList<AccountUser> getAccounUserstList() {
        return accounUserstList;
    }
}
