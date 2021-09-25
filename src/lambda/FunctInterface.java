package lambda;

@FunctionalInterface                // interfejs funkcyjny zawiera tylko jedną metodę abstrakcyjną
public interface FunctInterface {
    boolean metoda(int numb);

    @Override
    boolean equals(Object obj);     // Ponadto może zawierać metodę equals klasy Object i metody domyślne.

    default void doSth() {
        System.out.println("I did sth");
    }
}

/*
Najważniejsze interfejsy funkcyjne:

    Executable     nie przyjmuje żadnego obiektu ani na wejściu, ani na wyjściu                 () -> void

    Supplier<T>    nie przyjmuje żadnego obiektu na wejściu, ale zwraca obiekt (dostawca)       ()  -> T

    Consumer<T>    przyjmuje obiekt na wejściu, ale niczego nie zwraca (konsumer)               (T) -> void

    Predicate<T>   przyjmuje obiekt na wejściu i zwraca wartość PRAWDA lub FAŁSZ (predykat)     (T) -> boolean

    Function<T,R>  przyjmuje obiekt na wejściu i zwraca obiekt na wyjściu (funkcja)             (T) -> R

    Istnieje wiele więcej interfejsów funkcyjnych zamieszczonych w java.util.function m.in. BIConsumer, BIPredicate,
    BIFunction ..., które rozszerzają możliwości powyższych, czy takie, które je konkretyzują np. UnaryOperator, IntConsumer ...
    Czasami najprościej jest jednak zaprojektować swój własny interfejs.

 */