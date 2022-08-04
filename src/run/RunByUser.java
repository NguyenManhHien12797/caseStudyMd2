package run;

import login_register.Register;

import java.io.IOException;
import java.util.Scanner;

public class RunByUser{
    private final Register login = new Register();

    public RunByUser() throws IOException {
    }


    public void menu(){

        do{
            displayMenu();
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                case 2:
                    login.registerAccountUser();
                    menu();
                    break;
                case 3:
                    System.exit(3);
                default:
                    System.out.println("Nhập sai rồi!");
            }
        }while (true);

    }
    public void displayMenu(){
        System.out.println("1. Đăng nhập ");
        System.out.println("2. Đăng ký tài khoản");
        System.out.println("3. Thoát");
    }
}
