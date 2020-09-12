package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollList {
    public static void main(String[] args) {
        List<String> tab = new ArrayList<>(); /* ArrayList to lista tablicowa, szybki odczyt, ale trudne modyfikacje (np. do usuniecia
         elementu potrzeba przekopiowania calej tablicy do nowej, bez tego elementu)*/

        tab.add("ala");
        tab.add("ma");
        tab.add("kota");
        tab.add("ala");
        tab.remove("kota");

        List<String> list = new LinkedList<>(tab); /* LinkedList to lista wiazana (zlozona z wezlow - klasa Node<>),
        dluzszy odczyt, ale prostsze modyfikacje (np. do usuniecia elementu wystarczy "wyrwac" go, przerywajac jego linki
        z sasiadami, a sasiadujace elementy podlinkowac ze soba nawzajem. Kazdy element listy wiazanej (wezel) przechowuje
        informacje dotyczace przechowywanego elementu (jakiegos obiektu) oraz poprzedniego i nastepnego wezla(elementu) listy */

//      Taki kod wyrzuci blad ConcurrentModificationException:
//        for (String s : tab) {
//            tab.remove(s);
//        }
        /* w listach, podczas iterowania ich elementow, mozemy dokonywac modyfikacji o ile nie zmieniaja one rozmiaru naszej
        listy, wiec nie mozemy z niej bezposrednio usuwac elementow. Mozemy to za to robic przy uzyciu interfejsu Iterator:
         */
        for (Iterator<String> i = tab.iterator();  i.hasNext(); ) { //?
            i.next();
            i.remove();
        }
        for (String s : list) {
            System.out.println(s);
        }

    }
}
