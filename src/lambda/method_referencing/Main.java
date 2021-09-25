package lambda.method_referencing;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        /*
          Referencja metody niestatycznej konkretnej instancji (obiektu).
         */
        Object o = new Object();
        IntSupplier supp = o::hashCode;         // Referencja metody odbywa się przez utworzenie instancji interfejsu funkcyjnego
        System.out.println(supp.getAsInt());    // (IntSupplier) z implementacją jego metody (getAsInt), której ciałem staje się
        System.out.println(o.hashCode());       // ciało referowanej funkcji (hashCode klasy Object)

        /*
          Referencja metody niestatycznej dowolnej instancji (obiektu) konkretnego typu.

            UWAGA: Metoda ta przekazywana jest bez korzystania z konkretnej instancji typu, wymaga zatem, aby pierwszym
            z argumentów jej wywołania była instancja tego typu
            WNIOSEK: interfejs musi udostępniać metodę z o jeden więcej argumentem niż referowana metoda!
         */
        /* 1 */
        ToStringFunction<String> function = String::toLowerCase;
        function.fun("ROMEK"); // konkretna instancja typu String to "ROMEK"
        /* 2 */
        List<String> list = Arrays.asList("Felek", "Bartek", "Kuba");
        list.sort(String::compareTo);   // konkretna instancja typu String będzie pierwszym z pobieranych argumentów do
                                        // metody compare interfejsu Comparator<>, której ciałem będzie ciało metody compareTo

        /*
          Referencja metody statycznej.
         */
        ToStringFunction<String> supplier = String::valueOf;
        supplier.fun("ROMEK");

        /*
          Referencja konstruktora.
         */
                                                                // metoda interfejsowa ma tyle parametrów ile konstruktor
        Supplier<String> objectSupplier = String::new;          // konstruktor bezparametrowy
        ToStringFunction<String> stringFunction = String::new;  // konstruktor jednoparametrowy przyjmujący String


        List<Integer> numbers = Arrays.asList(56, 65, 2, 7, 9);
        numbers.forEach(System.out::println);
    }
}
