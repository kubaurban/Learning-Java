public class String_Builder {
    /** Klasa String jest napisana w sposob nieobiektowy - kazda modyfikacja obiektu tej klasy tworzy nowy obiekt klasy String.
     * Dobrym rozwiazaniem jest wiec dojscie do tablicy znakow z jakiej sklada sie String i jej modyfikacja bez tworzenia nowych
     * obiektów. Przydatna w tym celu (zwlaszcza przy operowaniu na wiekszych plikach) jest klasa StringBuilder (ew. StringBuffer)
     */
    public static void main(String[] args) {
        String string = "Jestem String";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string).append(", teraz chwilę byłem StringBuilder i znowu jestem String."); /* uzycie metody .append() na obiekcie klasy StringBuilder
        zapobiega tworzeniu pobocznych obiektów. Fragment "i znowu jestem String" wykona się w poleceniu stringBuilder.toString()*/
        System.out.println(stringBuilder.toString());
    }
}
