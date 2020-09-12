package wzorzec_Singleton;

public class Singleton { /* wzorzec projektowy wzorzec_Singleton.Singleton stosowany jest gdy musimy zapewnić wyłącznie jedną instancję
    klasy w obrębie całej aplikacji. W tym celu klasa musi:
     1) zablokowac mozliwosc tworzenia nowych instancji (prywatny konstruktor)
     2) przy pierwszym wywolaniu pobrania obiektu stworzyc go, a kazde kolejne wywolanie przekierowac na utworzony juz obiekt
     */
    private static Singleton onlyInstance; /* jedyna instancja tej klasy bedzie tutaj przechowywana jako jedno ze swoich pol
    (przechowuje siebie sama - swoja referencje) */

    private Singleton(){}

    public static Singleton getOnlyInstance() {
        if (onlyInstance == null) {
            onlyInstance = new Singleton(); // tutaj nastepuje jedyne utworzenie instancji klasy Singleton
        }
        return onlyInstance; // w innym wypadku, kiedy istnieje juz obiekt klasy Singleton, zwracana jest referencja na ten obiekt
    }
}
