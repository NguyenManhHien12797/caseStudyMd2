package run;

import account.AccountAdminManager;
import account.AccountUserManager;
import account.UserManager;
import login_register.Login;
import model_Manager.ConfectioneryManager;
import model_Manager.FastFoodManager;
import model_Manager.VietlottManager;
import view.Client;

import java.io.IOException;
import java.util.Scanner;

public class RunByAdmin {
    ConfectioneryManager confectioneryManager = ConfectioneryManager.getInstance();
    FastFoodManager fastFoodManager = FastFoodManager.getInstance();
    VietlottManager vietlottManager = VietlottManager.getInstance();
    UserManager userManager = UserManager.getInstance();
    AccountUserManager accountUserManager = AccountUserManager.getInstance();
    AccountAdminManager accountAdminManager = AccountAdminManager.getInstance();

    public RunByAdmin() throws IOException {
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
                            menuAddProduct();
                        break;
                    case 2:
                            menuEditProduct();
                        break;
                    case 3:
                            menuDeleteProduct();
                        break;
                    case 4:
                        confectioneryManager.display();
                        fastFoodManager.display();
                        vietlottManager.display();
                        break;
                    case 5:
                        menuDisplayInfo();
                        break;
                    case 6:
                        System.out.println("Chưa update");
                        break;
                    case 7:
                        System.out.println("Chưa update");
                        break;
                    case 0:
                        System.out.println("Đã thoát khỏi hệ thống Admin !!!");
                        System.out.println("----------------------------------------------------");
                       Login login = new Login();
                        login.menuLogin();
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


    public void menuAddProduct() throws IOException {
        Client client = new Client();
        try {
            do {
                System.out.println("Menu Add product");
                System.out.println("1. Confectionery");
                System.out.println("2. FastFood");
                System.out.println("3. Vietlott");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        client.addConfectionery();
                        break;
                    case 2:
                        client.addFastFood();
                        break;
                    case 3:
                        client.addVietlott();
                        break;
                    case 0:
                        System.out.println(" Đã thoát khỏi hệ thống Admin !!!");
                        System.out.println("----------------------------------------------------");
                        menuAdmin();
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

    public void menuEditProduct() throws IOException {
        Client client = new Client();
        try {
            do {
                System.out.println("Menu Edit product");
                System.out.println("1. Confectionery");
                System.out.println("2. FastFood");
                System.out.println("3. Vietlott");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menuEditProduct1();
                        break;
                    case 2:
                        menuEditProduct1();
                        break;
                    case 3:
                        menuEditProduct1();
                        break;
                    case 0:
                        System.out.println(" Đã thoát khỏi hệ thống Admin !!!");
                        System.out.println("----------------------------------------------------");
                        menuAdmin();
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

    public void menuEditProduct1(){
        try {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Menu Edit product");
                System.out.println("1. Edit Name");
                System.out.println("2. Edit Price");
                System.out.println("3. Edit Brand");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id= scanner.nextInt();
                        System.out.println("Nhập tên muốn đổi");
                        Scanner scanner1 = new Scanner(System.in);
                        String newName = scanner1.nextLine();
                        confectioneryManager.editName(id,newName);
                        System.out.println("Đổi tên thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 2:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id2= scanner.nextInt();
                        System.out.println("Nhập price muốn đổi");
                        double newPrice = scanner.nextDouble();
                        confectioneryManager.editPrice(id2,newPrice);
                        System.out.println("Đổi price thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 3:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id1= scanner.nextInt();
                        System.out.println("Nhập tên muốn đổi");
                        String newBrand = scanner.nextLine();
                        confectioneryManager.editBrand(id1,newBrand);
                        System.out.println("Đổi brand thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuEditProduct();
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
    public void menuDeleteProduct() throws IOException {
        Client client = new Client();
        try {
            do {
                System.out.println("Menu Delete product");
                System.out.println("1. Confectionery");
                System.out.println("2. FastFood");
                System.out.println("3. Vietlott");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        menuDeleteConfectionery();
                        break;
                    case 2:
                        menuDeleteFastFood();
                        break;
                    case 3:
                        menuDeleteVietlott();
                        break;
                    case 0:
                        System.out.println(" Đã thoát khỏi hệ thống Admin !!!");
                        System.out.println("----------------------------------------------------");
                        menuAdmin();
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

    public void menuDeleteConfectionery(){
        try {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Menu Delete product");
                System.out.println("1. Delete theo id");
                System.out.println("2. DeleteAll");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id= scanner.nextInt();
                        confectioneryManager.delete(id);
                        System.out.println("Delete thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 2:
                       confectioneryManager.deleteAll();
                        System.out.println("Delete All thành công");
                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuDeleteProduct();
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

    public void menuDeleteFastFood(){
        try {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Menu Delete product");
                System.out.println("1. Delete theo id");
                System.out.println("2. DeleteAll");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id= scanner.nextInt();
                        fastFoodManager.delete(id);
                        System.out.println("Delete thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 2:
                        fastFoodManager.deleteAll();
                        System.out.println("Delete All thành công");
                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuDeleteProduct();
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

    public void menuDeleteVietlott(){
        try {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Menu Delete product");
                System.out.println("1. Delete theo id");
                System.out.println("2. DeleteAll");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập id sản phẩm cần edit:");
                        int id= scanner.nextInt();
                        vietlottManager.delete(id);
                        System.out.println("Delete thành công");
                        System.out.println("------------------------------------");
                        break;
                    case 2:
                        vietlottManager.deleteAll();
                        System.out.println("Delete All thành công");
                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuDeleteProduct();
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

    public void menuDisplayInfo(){
        try {
            do {
                System.out.println("-------------------------------------");
                System.out.println("Menu thông tin khách hàng");
                System.out.println("1. Thông tin Account");
                System.out.println("2. Info khách hàng");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                       accountAdminManager.display();
                       accountUserManager.display();
                        System.out.println("------------------------------------");
                        break;
                    case 2:
                       userManager.display();
                        System.out.println("------------------------------------");
                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuAdmin();
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
