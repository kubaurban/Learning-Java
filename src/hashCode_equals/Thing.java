package hashCode_equals;

import java.util.Objects;

public class Thing {
        /* metoda hashCode() zwraca unikalna wartosc liczbowa typu int dla kazdego unikalnego obiektu
        metoda equals() porownuje referencje Obiektow */
        /* nadpisana metoda hashCode() zwraca takie same wartosci liczbowe typu int dla kazdego identycznego obiektu (o identycznych polach)
        nadpisana metoda equals() porownuje juz NIE referencje Obiektow, ale zwraca true jezeli obiekty sa identyczne (o identycznych polach) */

        private String name;
        private double price;

    public Thing(String name, double price){
            this.name = name;
            this.price = price;
        }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    // Poniewaz metoda equals() porownuje jedynie adresy obiektow, aby ja ufunkcjonalnic bedziemy musieli ja nadpisywac dla konkretnych
    // obiektow. Takie nadpisanie metody equals powinno :
    // 1* porównywać wartość referencji
    // 2* sprawdzać, czy przekazany jako argument obiekt NIE jest wartością null
    // 3* sprawdzać, czy przekazany obiekt jest tego samego typu co obiekt, na którym operujemy, a jeśli tak to dokonać rzutowania
    //   (bo jest on narazie typu Object, a nie tego ktorego chcemy porownac!)
    // 4* porównywać poszczególne pola obiektu zwracając uwagę na to, czy nie są one wartościami null,
    //   a jeśli są typami obiektowymi, to porównywać je także poprzez metode equals, a nie ==.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 1*
        if (o == null || getClass() != o.getClass()) return false; //2,3*
        Thing thing = (Thing) o; //rzutowanie o ktorym mowa w 3*
        return Double.compare(thing.price, price) == 0 &&
                Objects.equals(name, thing.name); //4*
    }

    public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public double getPrice () {
            return price;
        }

        public void setPrice ( double price){
            this.price = price;
        }
}
