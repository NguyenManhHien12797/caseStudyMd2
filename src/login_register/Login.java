package login_register;

import account.AccountAdminManager;
import account.AccountUserManager;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    private AccountUserManager accountUserManager = AccountUserManager.getInstance();
    private AccountAdminManager accountAdminManager = AccountAdminManager.getInstance();
    private final Register register = new Register();


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
            menuUser();

        } else {
            System.out.println("Nhập sai rồi");
        }


    }

    public void loginAdmin(String account, String password) {
        if (checkAccountAdmin(account, password)) {
            //gọi ra memuAdmin
            menuAdmin();

        } else {
            System.out.println("Nhập sai rồi");

        }
//        }

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


    public void menuAdmin() {
        try {
            do {
                System.out.println("Menu Admin");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Sửa info");
                System.out.println("3. Xóa sản phẩm");
                System.out.println("4. Hiền thị sản phẩm");
                System.out.println("5. Thông tin khách hàng");
                System.out.println("6. Doanh thu sản phẩm");
                System.out.println("0. Đăng xuất");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 0:
                        System.out.println("Đã thoát khỏi hệ thống USER !!!");
                        System.out.println("----------------------------------------------------");
                        menuLogin();
                        break;
                    default:
                        System.out.println("[❌] Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
        }
    }

    public void menuUser() {
        try {
            do {
                System.out.println("Menu User");
                System.out.println("1. Hiển thị sản phẩm trong shop");
                System.out.println("2. Tìm kiếm sản phẩm trong shop");
                System.out.println("3. Thêm sản phẩm vào giỏ hàng");
                System.out.println("4. Xóa sản phẩm khỏi giỏ hàng");
                System.out.println("5. Hiển thị sản phẩm trong giỏ hàng");
                System.out.println("6. Thanh toán");
                System.out.println("7. Lịch sử mua hàng");
                System.out.println("0. Đăng xuất");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 0:
                        System.out.println(" Đã thoát khỏi hệ thống USER !!!");
                        System.out.println("----------------------------------------------------");
                        menuLogin();
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
        }
    }

}
