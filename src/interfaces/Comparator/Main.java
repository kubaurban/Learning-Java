package interfaces.Comparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] koszyk = {
                new Cosmetic("Żel",30,1,"Souvre"),
                new Cosmetic("Szampon",15,2, "Souvre"),
                new Cosmetic("Pasta do zębów",17,1, "Colgate"),
                new Fruit("Arbuz",36,0.5),
                new Fruit("Banany",14,0.38)
        };
        Arrays.sort(koszyk, new ComparingMachine()); /* w argumentach funkcji .sort() nalezacej do klasy Arrays nalezy kolejno wpisac:
                                                         1) nazwe sortowanej tablicy 2) klase porownujaca obiekty w tej tablicy */
        System.out.println("Zawartosc koszyka posortowana wg cen malejaco:");
        for (Product product : koszyk) {
            System.out.println(product.toString());
        }
    }
}
