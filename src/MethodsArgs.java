public class MethodsArgs {
    public static void main(String[] args) {
        Integer[] a = {1};
        test(a);
        System.out.println(a[0]); // 3

        System.out.println();
        MethodsArgs metody = new MethodsArgs();
        metody.run();
    }

    public static void test(Integer[] liczba){
        liczba[0] = 3; /* do metod przekazywana jest WARTOSC parametrow, a wiec dla typow obiektowych jest to ich referencja:
                          utworzona zostaje kopia tej referencji (wskazujaca caly czas na ten sam obiekt w pamieci)
                          i to na niej dziala metoda */
        Integer[] b = {90};
        liczba = b; /* natomiast jesli probujemy nadac przekazanej referencji (a wlasciwie jej kopii) inna referencje
        (lub nadac nowa) nie nastapi zmiana "oryginalnej" referencji przekazywanej, ale jej kopia na ktorej dzialala metoda
        zostanie zastapiona inna/nowa referencja */
        System.out.println(liczba[0]); // 90
        liczba = null;
        System.out.println(liczba);
    }

    public static class Point{
        int cordX = 1;
        int cordY = 2;
    }

    private void run() {
        int a = 1;
        int b = 2;
        Point point = new Point();
        int result = count(a, b, point);
        System.out.println(result);

        System.out.println(a); //W JAVIE TYPY PROSTE PRZEKAZYWANE SA POPRZEZ WARTOSC, A NIE REFERENCJE
        System.out.println(point.cordX + ";"+ point.cordY); //ALE TYPY ZLOZONE TYLKO PRZEZ REFERENCJE!

        System.out.println(count(1,2,3,4,5,6)); // jesli chce wpisac duzo argumentow to korzystam w metodzie z argumentu typ...
    }
    private int count(final int a, int b, Point p) { // final typ_zmiennej nazwa_zmiennej - powoduje ze zmiennej nie mozna zmienic w obrebie metody
        // a=10; BLAD
        p.cordX = 10;
        p.cordY = 11;
        return a+b;
    }

    private int count(int... numbers) { // w ten sposob tworze tablice numbers wypelniona moimi argumentami
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
