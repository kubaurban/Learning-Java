package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/** Hierarchia:
 * klasa implementująca                                      interfejs (abstrakcja):
 * (o funkcjonalnosciach implementowanego interfejsu):
 * HashMap                                                   Map (funkcje odnoszace sie do mapy)
 * Node                                                      Entry (funkcje odnoszace sie do poszczegolnej pary key-value w mapie)
 */
public class CollMap {
    public static void main(String[] args) {
        Map<Integer, String> lista = new HashMap(
                Map.of(1,"Adamczyk",2,"Bąbel",3,"Czajnik",4,"Drwalski")
        );
        for (Map.Entry<Integer, String> entry : lista.entrySet()) { /* obiekt klasy HashMap przechowuje zbior elementow interfejsu
        Entry (wewnetrznego interfejsu interfejsu Map), funkcja .entrySet() zwraca referencje na ten zbior.
        W powyzszym przykladzie entry jest obiektem klasy Node<K,V> (wewnetrznej klasy HashMap, implementujacej interfejs
        Map.Entry), typu Entry. Reprezentuje pare key-value w danym obiekcie HashMapy */
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

/** Properties jest szczegolnym rodzajem mapy, ktory nie implementuje bezposrednio interfejsu Map, a moze przechowywac pary Object-
 * Object. Jej przeznaczenie sprowadza sie jednak do uzytkowania par String-String.
 * Tej kolekcji nie mozemy deklarowac polimorficznie (jesli chodzi o interfejs Map)!
 */
        Properties prop = new Properties();
    }
}
