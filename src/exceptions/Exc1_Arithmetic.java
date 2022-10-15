package exceptions;

/* schemat bloku try catch:

    try{
     	kod programu mogący generować wyjątki
     }
     catch (TypWyjątku1 a){ Obsługa wyjątku a }
     catch (TypWyjątku2 b){ Obsługa wyjątku b }
     ...
     finally{ Blok instrukcji, który wykona się niezależnie, czy wyjątki wystąpią, czy nie }

     *Użycie finally jest konieczne w przypadku, gdy w bloku try pojawia się intrukcja return
     (zwrócenie wartości przez metodę skutkuje jej natychmiastowym zakończeniem). Jeśli otaczamy blok try klauzulą finally
     to zostanie ona wykonana nawet w przypadku zwrócenia wartości przez metodę w bloku try.
 */

public class Exc1_Arithmetic {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
                                 // Obsługa wyjątków // tych wyjatkow (dziedz. z RuntimeException) nie trzeba obslugiwac!
        try {                          // try{} - w tej sekcji wpisujemy miejsce ktore chcemy zabezpieczyc przed wystapieniem wyjatku
            //System.out.println(a / b);
            System.out.println(division(a,b));
        } catch (ArithmeticException e) { // catch(typ_znalezionego_wyjatku nazwa_zmiennej){obsluga wyjatku}
            System.out.println("Nie dzielimy przez 0 !");
        }
        System.out.println("hejka");
    }

    public static int division(int a, int b) throws ArithmeticException { // za pomoca throws wyjatek zabezpieczamy metode ktora musi cos
        return a / b;                                        // zwracac, deklarujac ze w pewnym przypadku moze zwrocic (wyrzucic) wyjatek
    }
}
