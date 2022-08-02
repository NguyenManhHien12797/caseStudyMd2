package model;

public class FastFood extends Product{
    public FastFood(int id, double price, String name, String brand) {
        super(id, price, name, brand);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", price=" + getPrice() +
                ", name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                '}';
    }
}
