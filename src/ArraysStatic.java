import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraysStatic { // niektore przydatne statyczne metody klasy Arrays i Collections
    public static void main(String[] args) {
        String[] tab = {"gf","wr","gr","eb","ts","aa","wd"};

        /* sortuje tablice (alfabetycznie) za pomoca algorytmu quicksort. W przypadku podania obiektu
        interfaces.Comparator jako drugi parametr sortuje wg niego. Mozna skorzystac takze z Collections.sort(tab); */
        Arrays.sort(tab);

        // to samo, ale można w ten sposób swój Comparator:
        Arrays.sort(tab, new Comparator<String>() { // użycie klasy anonimowej
            @Override
            public int compare(String o1, String o2) {
                return  o1.compareTo(o2);
            }
        });

        List<String> strings = Arrays.asList(tab); //zwraca tablice jako liste
        for (String string : strings) {
            System.out.println(string);
        }

        Collections.reverse(Arrays.asList(tab)); // odwraca obiekt klasy List
        for (String string : Arrays.asList(tab)) {
            System.out.println(string);
        }

        Arrays.fill(tab,"aaa"); // wypelnia cala tablice identyczna wartoscia
        for (String string : Arrays.asList(tab)) {
            System.out.println(string);
        }

        // Collections.shuffle() - losowo miesza obiekty w liscie
    }
}
