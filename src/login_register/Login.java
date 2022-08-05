package login_register;

import account.AccountAdminManager;
import account.AccountUserManager;
import model_Manager.ConfectioneryManager;

import run.RunByAdmin;
import run.RunByUser;


import java.io.IOException;
import java.util.Scanner;

public class Login{
    private AccountUserManager accountUserManager = AccountUserManager.getInstance();
    private AccountAdminManager accountAdminManager = AccountAdminManager.getInstance();
    private final Register register = new Register();

    ConfectioneryManager confectioneryManager = ConfectioneryManager.getInstance();
   private final RunByUser runByUser = new RunByUser();
   private final RunByAdmin runByAdmin = new RunByAdmin();

    public Login() throws IOException {
    }

    public void login() {
        System.out.print("Mời nhập account:");
        Scanner scanner = new Scanner(System.in);
        String acc = scanner.nextLine();
        System.out.print("Mời nhập password:");
        Scanner inputPass = new Scanner(System.in);
        String pass = scanner.nextLine();
        String str = "ADMIN";
        if (acc.contains(str)) {
            loginAdmin(acc, pass);
        } else {
            loginUser(acc, pass);
        }

    }

    public void menuLogin() {

        a:
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break a;

                case 2:
                    register.registerAccountUser();
                    break;
                case 3:
                    System.exit(3);
                default:
                    System.out.println("Nhập sai rồi!");
            }
        } while (true);

    }

    public void displayMenu() {
        System.out.println("1. Đăng nhập ");
        System.out.println("2. Đăng ký tài khoản");
        System.out.println("3. Thoát");
    }

    public void loginUser(String account, String password) {
        if (checkAccountUser(account, password)) {
            //gọi ra menuUser
            runByUser.menuUser();

        } else {
            System.out.println("Nhập sai rồi");
            System.out.println("Mời nhập lại");
            login();
        }


    }

    public void loginAdmin(String account, String password) {
        if (checkAccountAdmin(account, password)) {
            //gọi ra memuAdmin
            runByAdmin.menuAdmin();

        } else {
            System.out.println("Nhập sai rồi");
            System.out.println("Mời nhập lại");
            login();
        }
    }


    public boolean checkAccountUser(String account, String password) {
        for (int i = 0; i < accountUserManager.getAccounUserstList().size(); i++) {
            String acc = accountUserManager.getAccounUserstList().get(i).getAccount();
            String pass = accountUserManager.getAccounUserstList().get(i).getPassword();
            if (account.equals(acc) && password.equals(pass))
                return true;
        }
        return false;
    }

    public boolean checkAccountAdmin(String account, String password) {
        for (int i = 0; i < accountAdminManager.getAccountAdminList().size(); i++) {
            String acc = accountAdminManager.getAccountAdminList().get(i).getAccountAdmin();
            String pass = accountAdminManager.getAccountAdminList().get(i).getPasswordAdmin();
            if (account.equals(acc) && password.equals(pass))
                return true;
        }
        return false;
    }
}
