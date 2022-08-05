package view;

import model.Confectionery;

import model.FastFood;
import model.Vietlott;
import model_Manager.ConfectioneryManager;
import model_Manager.FastFoodManager;
import model_Manager.VietlottManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    ConfectioneryManager confectioneryManager = ConfectioneryManager.getInstance();
    FastFoodManager fastFoodManager = FastFoodManager.getInstance();
VietlottManager vietlottManager = VietlottManager.getInstance();
    public Client() throws IOException {
    }

    public void addConfectionery(){
        int id= confectioneryManager.size()+1;
        System.out.println(" Nhập tên sản phẩm:");
        Scanner inputName= new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Nhập price: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập brand: ");
        Scanner inputBrand = new Scanner(System.in);
        String brand = inputBrand.nextLine();
        Confectionery confectionery = new Confectionery(id,name,price,brand);
        confectioneryManager.add(confectionery);

    }

    public void addFastFood(){
        int id= fastFoodManager.size()+1;
        System.out.println(" Nhập tên sản phẩm:");
        Scanner inputName= new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Nhập price: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập brand: ");
        Scanner inputBrand = new Scanner(System.in);
        String brand = inputBrand.nextLine();
        FastFood fastFood = new FastFood(id,name,price,brand);
        fastFoodManager.add(fastFood);

    }
//    public void addDrinks(){
//        int id= drinksManager.size()+1;
//        System.out.println(" Nhập tên sản phẩm:");
//        String name = scanner.nextLine();
//        System.out.println("Nhập price: ");
//        double price = scanner.nextDouble();
//        System.out.println("Nhập brand: ");
//        Scanner inputBrand = new Scanner(System.in);
//        String brand = inputBrand.nextLine();
//        Drinks drinks = new Drinks(id,name,price,brand);
//        drinksManager.add(drinks);
//
//    }

    public void addVietlott(){
        System.out.println(vietlottManager.size()+1);
        int id= vietlottManager.size()+1;
        System.out.println(" Nhập tên người chơi:");
        Scanner inputName= new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println(" Nhập lucky number:");
        Scanner number = new Scanner(System.in);
        String luckyNumber = scanner.nextLine();
        System.out.println("Nhập price: ");
        double price = scanner.nextDouble();
        System.out.println("Nhập brand: ");
        Scanner inputBrand = new Scanner(System.in);
        String brand = inputBrand.nextLine();
        LocalDateTime dateTime = LocalDateTime.now();

        Vietlott vietlott = new Vietlott(id,name,luckyNumber,price,brand,dateTime);
        vietlottManager.add(vietlott);

    }
}
