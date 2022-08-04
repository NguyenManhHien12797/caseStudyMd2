package view;

import account.*;
import login_register.Login;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.IOException;

public class Main {
    private final IOFile<AccountUser> ioFileBinary= IOFileBinary.getInstance();

    public static void main(String[] args) throws IOException {
//        Register register = new Register();
////        register.registerAccountUser();
////
//        AccountUserManager accountUserManager = AccountUserManager.getInstance();
////        accountUserManager.removeAll();
//        accountUserManager.display();
//        Login login = new Login();
//        login.loginAdmin("ADMIN3","123456");

//        System.out.println( login.checkAccountUser("Dungdung","dungdung"));
//        System.out.println( login.checkAccountUser("Hienhien","hienhien"));

//        AccountAdminManager accountAdminManager = AccountAdminManager.getInstance();
//        accountAdminManager.AccountAdmin();
//        accountAdminManager.display();

        Login login = new Login();
        login.menuLogin();
    }
}

