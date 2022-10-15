package interfaces.Comparator;

public abstract class Product {

    private String name;
    protected double price;

    public abstract double getPrice();

    @Override
    public String toString() {
        return name +": Cena=" + getPrice();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
