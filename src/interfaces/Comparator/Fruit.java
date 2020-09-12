package interfaces.Comparator;

public class Fruit extends Product {

    private double weight;

    public Fruit(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " Waga=" + weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getPrice() {
        return super.price*weight;
    }
}
