package view;

import account.User;
import account.UserManager;
import login.Login;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static IOFile ioFileBinary = new IOFileBinary();

    public static void main(String[] args) throws IOException {
        Login login = new Login();
//        login.registerAccountUser();
        ArrayList<User> users = ioFileBinary.readFile("user.dat");
        for (User userList : users) {
            System.out.println(userList);

        }
    }
}

