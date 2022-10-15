package collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollQueue { /*kolejki pozwalaja szeregowac dodane elementy w kolejnosci dodawania(podobnie jak listy), oferuja takze
m.in. ograniczanie rozmiaru kolejki, sprawdzanie czy poprawnie zostal dodany element, pobieranie elementow ze srodka. */

    public static void main(String[] args) {
        /*Charakterysteczne metody interfejsu Queue:
        * poll() – zwraca i usuwa element znajdujący się na szczycie kolejki
        * peek() – zwraca element znajdujący się na szczycie kolejki
        * remove() – to samo co poll(), ale podnosi wyjątek jeśli kolejka jest pusta (jesli poll() zwraca null)
        * offer() – podejmuje próbę dodania elementu na koniec kolejki – zwraca true jeśli operacja się powiodła,
                    false, jeśli przekroczymy ładowność kolejki
        */
        Queue<String> que = new ArrayDeque<>(); /* ArrayDeque nie jest ograniczona przez rozmiar, dostosowuje sie rozmiarem do
        dodawanych elementow. */

        Queue<String> pque = new PriorityQueue<>(3, new Comparing()); /* PriorityQueue dodając nowy element
        do kolekcji od razu wskakuje na pozycję wynikającą z jakiegoś sortowania (interfejs interfaces.Comparator). Deklaracja moze odbywac
        sie za pomoca dwoch parametrow: new PriorityQueue<Object o>(objętość_kolejki,obiekt_Comparator);
        obiekt_Comparator wyznacza rodzaj sortowania kolejki (powyzej sortuje rosnaco - alfabet.).
        UWAGA: petla for-each nie uwzgledni sortowania i zwroci wg kolejnosci dodawania*/
        pque.add("Kuba");
        pque.add("Małgosia");
        pque.add("Stefan");
        pque.add("Aneta");
        while (pque.size() > 0) {
            System.out.println(pque.poll());
        }
    }
}
