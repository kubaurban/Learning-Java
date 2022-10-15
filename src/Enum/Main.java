package Enum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Matrix", "Sci-fi"), // Stringi są wrażliwe na literówki
                new Movie("Jurrasic Park", "Sci-FI"),
                new Movie("Piła", "Horror"),
                new Movie("Titanic", "Romantic")
        );

        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj kategorię");
//        String line = scn.nextLine(); // więc w tym momencie kiedy uzytkownik wpisze "Sci-fi" nie otrzyma wszystkich filmow w tym gatunku
//        for (Movie movie : movies) {
//            if (movie.getStringMovieCategory().equals(line)){
//                System.out.println(movie.getTitle());
//            }
//        }


        List<Movie> movies2 = Arrays.asList(
                new Movie("Matrix", MovieCategory.SCI_FI), /* Enumy są z góry przez programiste zadeklarowane, pozwala to ujednolicic pisownie,
                jednak pociaga to za soba niepraktyczny problem, jakim jest koniecznosc zmiany calego gotowego i dzialajacego juz programu w przypadku checi
                dodania jakiejs nowej wartosci do Enuma. Obiektow Enum sie nie tworzy (tak jak inne Obiekty za pomoca slowka "new", jedynie odwoluje sie do
                konkretnego Enuma i wybiera z niego daną wartosc: Nazwa_Enuma.zdefinowana_wczesniej_w_enumie_wartosc */
                new Movie("Jurrasic Park", MovieCategory.SCI_FI),
                new Movie("Piła", MovieCategory.HORROR),
                new Movie("Titanic", MovieCategory.ROMANTIC)
        );

        MovieCategory[] categories = MovieCategory.values(); // .values() zastosowana na Enumie zwraca ta
        System.out.println("z dostępnych poniżej:");
        for (MovieCategory category : categories) {
            System.out.println(category.toString()); // zamiast .toString() można użyć .name()
        }

//        MovieCategory2[] categories = MovieCategory2.values();
//
//        System.out.println("z dostępnych poniżej:");
//        for (MovieCategory2 category : categories) {
//            System.out.println(category.getDisplayName()); // przyklad gdzie Enum zwraca wartosc swojego pola, a nie swoja wartosc
//        }

        /* alternatywana metoda, żeby porownac Enuma ze Stringiem to zamiana Stringa na Enum:
                MovieCategory enumLine = MovieCategory.valueOf(line);
         */
        String line = scn.nextLine();
        for (Movie movie : movies2) {
            if (movie.getEnumMovieCategory().toString().equals(line)) { //przed porownaniem nalezy zamienic Enuma na Stringa
                System.out.println(movie.getTitle());
            }
        }
    }
    /* Troche funkcji na wartosciach Enumu:
    1). .ordinal() - zwraca liczbe calkowita reprezentujaca, na ktorym z kolei miejscu zostala zadeklarowana dana wartosc w Enumie
        MovieCategory2.SCI_FI.ordinal() zwroci w naszym przypadku liczbe 1, poniewaz wartosc SCI_FI zostala zadeklarowana jako druga
    2). .compareTo(inna_wartosc_enumu) - porownuje dwie wartosci Enumu i zwraca roznice liczb ktore zwroci dla nich funkcja .ordinal()
        np.
        MovieCategory romantic = MovieCategory.ROMANTIC;
        MovieCategory horror = MovieCategory.HORROR;
        System.out.println(romantic.compareTo(horror)); zwroci wartosc 2, bo "romantic.ordinal() - horror.ordinal() = 2"
     */
}
