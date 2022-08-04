package view;

import account.*;
import login_register.Register;
import run.RunByUser;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private final IOFile<AccountUser> ioFileBinary= IOFileBinary.getInstance();

    public static void main(String[] args) throws IOException {
        Register register = new Register();
        register.registerAccountUser();

        AccountUserManager accountUserManager = AccountUserManager.getInstance();
        accountUserManager.display();


//        RunByUser run = new RunByUser();
//        run.menu();
    }
}

