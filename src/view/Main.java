package view;

import login_register.Login;
import model.Confectionery;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Confectionery>confectioneries = new ArrayList<>();

        Login login = new Login();
        login.menuLogin();
    }
}

