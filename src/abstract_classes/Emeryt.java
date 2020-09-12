package abstract_classes;
/* klasy abstrakcyjne tworzymy w przypadku gdy nie bedziemy potrzebowali bezposrednio tworzyc ich obiektow, ale skupia ona cechy
wspolne klas, ktorych obiekty chcemy tworzyc. Np. klasa Product w aplikacji obslugujacej sklep moglaby byc klasa abstrakcyjna,
a klasy Fruit i Vegetable moglyby po niej dziedziczyc */

public abstract class Emeryt {  // abstrakcyjna klasa moze przechowywac:
    public static final int ILOSC_OCZU = 2; /* final oznacza ze referencja obiektu jest ostateczna, co oznacza ze nie mozna do niej
    przypisac nowego lub juz istniejacego obiektu, natomiast gdyby final dotyczylo obiektu zlozonego z pol/innych obiektow
    (nieoznaczonych slowkiem final) to te pola/obiekty mozna zmieniac poniewaz nie sa w zaden sposob zwiazane z referencja obiektu
    "nadrzednego" */

    public abstract String krzyczNaDzieci(); // metody abstrakcyjne - nie majace implementacji!

    public static void biegnijDoSklepu(int odleglosc, int predkosc) { // zwykle metody zawierajace implementacje
        double czas = (double) odleglosc / predkosc;
        System.out.println("Biegne po kiełbase bede za " + czas);
    }

    public static int getIloscOczu() {
        return ILOSC_OCZU;
    }
}

