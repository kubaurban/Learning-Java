package interfaces.Comparator;

import java.util.Comparator;

public class ComparingMachine implements Comparator<Product> {
    /** W klasie porownujacej wazne jest zaimplementowanie interfejsu Comparator<> albo Comparable<>.
     * W przypadku implementacji Comparable<> mozemy to zrobic od razu w klasie Product, bez tworzenia osobnej klasy porownujacej.
     * Jednak ponizsze rozwiazanie pozwala (w przeciwienstwie do Comparable<>) na utworzenie kilku komparatorow sortujacych na rozne sposoby */
    @Override
    public int compare(Product o1, Product o2) { /* dzieki takiemu porownaniu jestem w stanie szybko posortowac produkty
                                                    po cenie (patrz Main) */
        if(o1.getPrice() < o2.getPrice()){
            return 1;
        } else if(o1.getPrice() > o2.getPrice()) {
            return -1;
        }
        return 0;
    }
}

