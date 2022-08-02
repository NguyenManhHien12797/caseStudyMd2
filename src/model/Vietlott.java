package model;

public class Vietlott extends Product{
    String luckyNumber;
    public Vietlott(int id, double price, String name, String brand, String luckyNumber) {
        super(id, price, name, brand);
        this.luckyNumber= luckyNumber;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    @Override
    public String toString() {
        return "Vietlott{" +
                super.toString()
                +
                "luckyNumber='" + luckyNumber + '\'' +
                '}';
    }
}
