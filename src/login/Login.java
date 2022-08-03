package login;

import account.AccountUser;
import account.AccountUserManager;
import account.User;
import account.UserManager;
import validate.Validate;


import java.io.IOException;

import java.util.Scanner;

public class Login  {
    private int num=0;
    private final String PATH_FILE_USER = "user.dat";
    private final String PATH_FILE_ACCOUNT_USER= "account_user.data";

    private Scanner scanner = new Scanner(System.in);
    private Validate validate = new Validate();

    private UserManager userManager = new UserManager(PATH_FILE_USER);
    private AccountUserManager accountUserManager = new AccountUserManager(PATH_FILE_ACCOUNT_USER);
    public Login() throws IOException {
    }

    public void registerAccountUser() {
        String id = getId();
        String account = registerAccount();
        String password = registerPassword();
        System.out.print("Mời nhập tên: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("Mời nhập địa chỉ: ");
        String address = scanner.nextLine();
        String phoneNumber = registerPhoneNumber();
        String email = registerEmail();

        AccountUser accountUser = new AccountUser(account,password);
        User user = new User(id,name,address,phoneNumber,email);
        userManager.add(user,PATH_FILE_USER);
        accountUserManager.add(accountUser,PATH_FILE_ACCOUNT_USER);
    }

    public String getId(){
        String id = "USER"+userManager.size()+1 ;
        return id;
    }

    public String registerAccount() {
        String account;
        System.out.print("Nhập account: ");
        String inputAccount = scanner.nextLine();
        while (true) {
            if (!validate.validateAccount(inputAccount)) {
                System.out.println("Mời nhập lại: ");
                System.out.println("Account không chứa ký tự đặc biệt; ít nhất 8 ký tự; cho phép dấu gạch dưới ");
                inputAccount = scanner.nextLine();
            } else {
                account = inputAccount;
                break;
            }
        }
        return account;
    }

    public String registerPassword() {
        String password;
        System.out.print("Nhập password: ");
        String inputPassword = scanner.nextLine();
        while (true) {
            if (!validate.validatePassword(inputPassword)) {
                System.out.println("Mời nhập lại: ");
                System.out.println("Password không chứa ký tự đặc biệt; ít nhất 8 ký tự; cho phép dấu gạch dưới ");
                inputPassword = scanner.nextLine();
            } else {
                password = inputPassword;
                break;
            }
        }
        return password;
    }

    public String registerPhoneNumber() {
        String phoneNumber;
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        while (true) {
            if (!validate.validatePhoneNumber(phone)) {
                System.out.println("Mời nhập lại: ");
                System.out.println("Số điện thoại bắt đầu từ 0 có 10 chữ số 0-9 ");
                phone = scanner.nextLine();
            } else {
                phoneNumber = phone;
                break;
            }
        }
        return phoneNumber;
    }

    public String registerEmail() {

        String email;
        System.out.print("Nhập email: ");
        String inputEmail = scanner.nextLine();
        while (true) {
            if (!validate.validateEmail(inputEmail)) {
                System.out.println("Mời nhập lại: ");
                System.out.println("Email bắt đầu bằng 1 ký tự; không chứ ký tự đặc biệt, có ký tự @ ngăn cách tên email và domain; domain phải hợp lệ ");
                inputEmail = scanner.nextLine();
            } else {
                email = inputEmail;
                break;
            }
        }
        return email;
    }
}
