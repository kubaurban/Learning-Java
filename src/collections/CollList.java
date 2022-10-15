package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollList {
    public static void main(String[] args) {
        List<String> tab = new ArrayList<>(); /* ArrayList to lista tablicowa, szybki odczyt, ale trudne modyfikacje (np. do usuniecia
         elementu potrzeba przekopiowania całej tablicy do nowej, bez tego elementu)*/

        tab.add("ala");
        tab.add("ma");
        tab.add("kota");
        tab.add("ala");
        tab.remove("kota");

        List<String> list = new LinkedList<>(tab); /* LinkedList to lista wiązana (złożona z węzłów - klasa Node<>),
        dłuższy odczyt, ale prostsze modyfikacje (np. do usunięcia elementu wystarczy "wyrwać" go, przerywając jego linki
        z sąsiadami, a sąsiadujące elementy podlinkować ze sobą nawzajem. Każdy element listy wiązanej (węzeł) przechowuje
        informacje dotyczące przechowywanego elementu (jakiegoś obiektu) oraz poprzedniego i następnego węzła(elementu) listy */

        list.remove("ala");
//      Taki kod wyrzuci blad ConcurrentModificationException:
//        for (String s : tab) {
//            tab.remove(s);
//        }
        /* w listach, podczas iterowania ich elementow, mozemy dokonywac modyfikacji o ile nie zmieniaja one rozmiaru naszej
        listy, wiec nie mozemy z niej bezposrednio usuwac elementow. Mozemy to za to robic przy uzyciu interfejsu Iterator:
         */
        for (Iterator<String> i = tab.iterator();  i.hasNext(); ) {
            i.next();
            i.remove();
        }
        for (String s : list) {
            System.out.println(s);
        }

    }
}
