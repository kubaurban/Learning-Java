package extending;

public class Zwierzyniec {
    public static void main(String[] args) {
        Cat c1 = new Cat(11,12,"mruczus","bialy",9);
        Animal a1 = new Cat(11,12,"mruczus","bialy",9);
            /* typ a1 to Animal, nie moge skorzystac dla niego z funkcjonalnosci ktore naleza jedynie do Cat, a do Animal nie,
            np. NIE moge wywolac zawolania:
        a1.getLives() BŁĄD! */
        ((Cat)a1).getLives(); /* powyższy problem moge rozwiazac stosujac konwersje rozszerzajaca !!! */
        c1.speak();
        System.out.println(c1.toString());
        a1.speak();
        System.out.println(a1.toString());
        System.out.println(c1.weight); // uzyskane za pomoca operatora protected w klasie Animal

    }
}
