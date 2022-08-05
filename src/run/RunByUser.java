package run;

import login_register.Login;
import model.Confectionery;
import model.FastFood;
import model.Vietlott;
import model_Manager.CartManager;
import model_Manager.ConfectioneryManager;
import model_Manager.FastFoodManager;
import model_Manager.VietlottManager;
import storage.IOFile;
import storage.IOFileBinary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunByUser {
    private final String PATH_CONFECTIONERY = "fileData/confectionery.dat";
    private final String PATH_CONFECTIONERYRCART = "fileData/usercart.dat";
    private final String PATH_FASTFOODCART = "fileData/fastFoodCart.dat";
    private final String PATH_VIETLOTTCART = "fileData/vietlottCart.dat";
    CartManager cartManager = CartManager.getInstance();
    private ArrayList<Confectionery> confectioneryCartList = new ArrayList<>();
    private ArrayList<FastFood> fastFoodsCartList = new ArrayList<>();
    private ArrayList<Vietlott> vietlottsCartList = new ArrayList<>();

    ConfectioneryManager confectioneryManager = ConfectioneryManager.getInstance();
    FastFoodManager fastFoodManager = FastFoodManager.getInstance();
    VietlottManager vietlottManager = VietlottManager.getInstance();


    IOFile<Confectionery> confectioneryIOFile = IOFileBinary.getInstance();
    IOFile<FastFood> fastFoodIOFile = IOFileBinary.getInstance();
    IOFile<Vietlott> vietlottIOFile = IOFileBinary.getInstance();

    public RunByUser() throws IOException {
    }

    public void menuUser() {
        try {
            do {
                System.out.println("-------------------------------------------------------------------------------------------------------");
                System.out.println("                                           Menu User");
                System.out.println("                                1. Hiển thị sản phẩm trong quán");
                System.out.println("                                2. Tìm kiếm sản phẩm trong quán");
                System.out.println("                                3. Thêm sản phẩm vào giỏ hàng");
                System.out.println("                                4. Xóa sản phẩm khỏi giỏ hàng");
                System.out.println("                                5. Hiển thị sản phẩm trong giỏ hàng");
                System.out.println("                                6. Thanh toán");
                System.out.println("                                7. Lịch sử mua hàng");
                System.out.println("                                0. Đăng xuất");
                System.out.print("                                  Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------");
                        System.out.println("                            Hiển thị sản phẩm trong quán");
                        System.out.println("                                    Confectionery");
                        confectioneryManager.display();
                        System.out.println("                                     FastFood");
                        fastFoodManager.display();
                        System.out.println("                                      Vietlott");
                        System.out.println("-------------------------------------------------------------------------------------------------------");

                        break;
                    case 2:
                        System.out.println("Chưa update :)))");
                        break;
                    case 3:
                        menuCategory();
                        break;
                    case 4:
                        menuDeleteProductToCart();
                        break;
                    case 5:
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("                                           Menu giỏ hàng                                        ");
                        System.out.println(confectioneryIOFile.readFile(PATH_CONFECTIONERYRCART));
                        System.out.println(fastFoodIOFile.readFile(PATH_FASTFOODCART));
                        System.out.println(vietlottIOFile.readFile(PATH_VIETLOTTCART));
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 6:
                        System.out.println(" Chưa update!!");
                        break;
                    case 7:
                        System.out.println("Chưa update!!");
                        break;
                    case 0:
                        System.out.println(" Đã thoát khỏi hệ thống USER !!!");
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
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public void menuCategory() {
        try {
            do {
                System.out.println("--------------------------------------------------");
                System.out.println("                 Menu Add to cart");
                System.out.println("1. Confectionery");
                System.out.println("2. FastFood");
                System.out.println("3. Vietlott");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addConfectioneryToCart();
                        break;
                    case 2:
                        addFastFoodToCart();
                        break;
                    case 3:
                        addVietlottToCart();
                        break;
                    case 0:
                        System.out.println("                Đã quay lại !!!");
                        System.out.println("----------------------------------------------------");
                        menuUser();
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

    public void addConfectioneryToCart() {
        System.out.println("-------------------------------------------------------");
        System.out.println("                    Thêm sản phẩm");
        System.out.print("Nhập id sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        int inputid = scanner.nextInt();

        for (int i = 0; i < confectioneryManager.getConfectionerytList().size(); i++) {
            int id = confectioneryManager.getConfectionerytList().get(i).getId();

            if (inputid == id) {
                Confectionery a = confectioneryManager.getConfectionerytList().get(i);
                confectioneryCartList.add(a);
                confectioneryIOFile.writeFile(PATH_CONFECTIONERYRCART, confectioneryCartList);
            }
        }
        System.out.println("               Đã thêm thành công");
        System.out.println("-----------------------------------------------------");


    }

    public void addFastFoodToCart() throws IOException {
        createdFileFastFood();
        System.out.println("-----------------------------------------------------");
        System.out.println("                  Thêm sản phẩm");
        System.out.print("Nhập id sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        int inputid = scanner.nextInt();

        for (int i = 0; i < fastFoodManager.getFastFoodsList().size(); i++) {
            int id = fastFoodManager.getFastFoodsList().get(i).getId();

            if (inputid == id) {
                FastFood a = fastFoodManager.getFastFoodsList().get(i);
                fastFoodsCartList.add(a);
                fastFoodIOFile.writeFile(PATH_FASTFOODCART, fastFoodsCartList);

            }
        }
        System.out.println("                Đã thêm thành công");
        System.out.println("-----------------------------------------------------");

    }

    public void addVietlottToCart() throws IOException {
        createdFileVietlott();
        System.out.println("----------------------------------------------");
        System.out.println("              Thêm sản phẩm");
        System.out.print("Nhập id sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        int inputid = scanner.nextInt();

        for (int i = 0; i < vietlottManager.getVietlottsList().size(); i++) {
            int id = vietlottManager.getVietlottsList().get(i).getId();

            if (inputid == id) {
                Vietlott a = vietlottManager.getVietlottsList().get(i);
                vietlottsCartList.add(a);
                vietlottIOFile.writeFile(PATH_VIETLOTTCART, vietlottsCartList);

            }
        }
        System.out.println("Đã thêm thành công");
        System.out.println("-------------------------------------");

    }
    public void menuDeleteProductToCart() {
        try {
            do {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("                       Menu Delete to cart");
                System.out.println("1. Confectionery");
                System.out.println("2. FastFood");
                System.out.println("3. Vietlott");
                System.out.println("0. Quay lại");
                System.out.print("Mời bạn nhập lựa chọn: ");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        deleteConfectioneryToCart();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 0:
                        System.out.println(" Đã quay lại !!!");
                        System.out.println("----------------------------------------------------------");
                        menuUser();
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------------");
        }
    }
    public void deleteConfectioneryToCart(){
        System.out.println("-------------------------------------------------------------");
        System.out.println(confectioneryIOFile.readFile(PATH_CONFECTIONERYRCART));
        System.out.print("Nhập id sản phẩm cần xóa: ");
        Scanner scanner = new Scanner(System.in);
        int inputId = scanner.nextInt();
        for(int i= 0; i<confectioneryIOFile.readFile(PATH_CONFECTIONERY).size();i++){
            int id = confectioneryIOFile.readFile(PATH_CONFECTIONERY).get(i).getId();
            if(inputId == id ){
                confectioneryCartList.remove(i);
                confectioneryIOFile.writeFile(PATH_CONFECTIONERY,confectioneryCartList);
            }
        }
        System.out.println("                   Đã xóa thành công");
        System.out.println(confectioneryIOFile.readFile(PATH_CONFECTIONERYRCART));
        System.out.println("------------------------------------------------------------");
    }

    public void createdFileFastFood() throws IOException {
        File file = new File(PATH_FASTFOODCART);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            fastFoodsCartList = new ArrayList<>();
        } else {
            fastFoodsCartList = fastFoodIOFile.readFile(PATH_FASTFOODCART);
        }
    }

    public void createdFileVietlott() throws IOException {
        File file = new File(PATH_VIETLOTTCART);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.length() == 0) {
            vietlottsCartList = new ArrayList<>();
        } else {
            vietlottsCartList = vietlottIOFile.readFile(PATH_VIETLOTTCART);
        }
    }
}
