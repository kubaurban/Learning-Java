public class ConditionalOperator { /* celem uzycia tego operatora jest wstawienie wlasciwej wartosci pod zmienna w zaleznosci
    od danego warunku, jego struktura wyglada nastepujaco:
    typ_zmiennej nazwa_zmiennej = (warunek) ? value_if_true : value_if_false
    */
    public static void main(String[] args) {
        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30; // -> jezeli a jest rowne 1, to podstaw pod b 20, w przeciwnym razie podstaw pod b 30.
        System.out.println( "Value of b is : " +  b );

        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );
    }
}
