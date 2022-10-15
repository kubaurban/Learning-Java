package interfaces.Comparator;

public class Cosmetic extends Product {

    private int quality;
    private String brand;

    public Cosmetic(String name, double price, int quality, String brand) {
        super(name, price);
        this.quality = quality;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() + " Marka=" + brand + " Jakość=" + quality;
    }

    @Override
    public double getPrice() {
        return super.price*quality;
    }
}
