package hashCode_equals;

public class DefaultImplement {     // Domyslna metoda hashCode (jest to metoda klasy Object)
    public static void main(String[] args) {
        Product prod1 = new Product("Czekolada", 2.99);
        Product prod2 = new Product("Czekolada", 2.99);
        System.out.println(prod1.equals(prod2)); // false, bo porownuje tylko referencje (adresy)
        System.out.println(prod1.hashCode()); //1531448569
        System.out.println(prod2.hashCode()); //1867083167

        /* domyslna metoda hashCode zwroci rozne liczby dla idntycznych obiektow. Mimo identycznych zawartosci metoda equals()
        także nie zwroci true */
    }
}
