package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        int numb = 5;

        // każde wyrażenie lambda jest instancją interfejsu funkcyjnego!
        // tzn, że definiując ciało lambdy, tak naprawdę definiujemy ciało metody abstrakcyjnej interfejsu, którego jest instancją.
        FunctInterface inter = (param) -> param >= 0;
        System.out.println(inter.metoda(numb));

        inter.doSth();

        List<String> list = Arrays.asList("Felek", "Bartek", "Kuba");
        Collections.sort(list, (String o1, String o2) -> o1.compareTo(o2)); // kompilator sam wnioskuje interfejs funkcyjny dla lambdy

        List<Integer> numbers = Arrays.asList(56, 65, 2, 7, 9);
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);

        numbers.forEach(i -> System.out.println(i));
    }
}
