package hashCode_equals;

public class OwnImplement { // Własna implementacja metody hashCode i equals poprzez jej nadpisanie
    public static void main(String[] args) {
            Thing th1 = new Thing("Czekolada", 2.99);
            Thing th2 = new Thing("Czekolada", 2.99);

            System.out.println(th1.equals(th2)); // true, bo juz nie porownuje tylko referencji (adresy)

            System.out.println(th1.hashCode()); //-768595354
            System.out.println(th2.hashCode()); //-768595354

        /* Po nadpisaniu metody (wygenerowanej przez IntelliJ IDEA) hashCode() zwroci ona identyczne numery dla identycznych obiektow, ale
        metoda equals() nadal nie zwroci true. Dopiero po jej nadpisaniu (równiez przez IntelliJ) porownuje ona juz nie referencje,
        ale wszystkie pola Obiektu - zwroci wiec true dla identycznych Obiektow.
        UWAGA: nadpisanie hashCode() i equals() NIE ma ze soba zwiazku w tym przykladzie! */
    }
}
