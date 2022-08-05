package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vietlott implements Serializable {
    private int id;
    private String name;
    String luckyNumber;
    private double price;
    private String brand;
    private LocalDateTime dateTime;

    public Vietlott() {
    }

    public Vietlott(int id,String name, String luckyNumber,double price,String brand, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.luckyNumber = luckyNumber;
        this.price = price;
        this.brand = brand;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vietlott{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", luckyNumber='" + luckyNumber + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
