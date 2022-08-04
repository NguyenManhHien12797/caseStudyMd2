package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Bill {
    private String userName;
    private ArrayList<Product> products;
    private double totalPrice;
    private LocalDateTime purchaseDate;

    public Bill(String userName, ArrayList<Product> products, double totalPrice, String purchaseDate) {
        this.userName = userName;
        this.products = products;
        this.totalPrice = totalPrice;
        this.purchaseDate = LocalDateTime.parse(purchaseDate);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
