package view;

import account.*;
import login.Login;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static IOFile ioFileBinary = new IOFileBinary();

    public static void main(String[] args) throws IOException {
        Login login = new Login();
        login.registerAccountUser();
        ArrayList<User> users = ioFileBinary.readFile("user.dat");
        ArrayList<AccountUser> accountUsers = ioFileBinary.readFile("account_user.data");


        Manager manager= new UserManager("user.dat");
//        manager.remove("","user.dat");
        manager.display("user.dat");
//        manager.removeAll("user.dat");
        System.out.println(manager.size());

        Manager manager1 = new AccountUserManager("account_user.data");
//        manager1.removeAll("account_user.data");
        manager1.remove("DucAnh123","account_user.data");
        manager1.display("account_user.data");
    }
}

