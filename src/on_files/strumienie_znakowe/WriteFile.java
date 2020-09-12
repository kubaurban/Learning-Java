package on_files.strumienie_znakowe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    /**
     Do pisania i czytania z plików używamy klas FileWriter, PrintWriter, BufferedReader, FileReader.
     */
    public static void main(String[] args) throws IOException {
        File file = new File("tekst2.txt");
        if (file.exists()) {
            System.err.println("PLIK JUZ ISTNIEJE"); // sposob na wyswietlenie tekstu w konwencji bledu (skrot serr)
        } else{
            boolean bool = file.createNewFile(); // tworzy nowy plik, zwraca boolean, czy zostal utworzony
            System.out.println(bool);
        }

        PrintWriter writer = new PrintWriter(file);
        writer.println("Ala ma kotaaa");
        writer.print("A Ania ma dwa koty");
        writer.close(); // PrintWriter wymaga zamkniecia swojego obiektu zeby wszystkie dane z buforu zostaly wczytane

        FileWriter writer2 = new FileWriter(file); // ta sekwencja da ten sam efekt jak powyzsza
        writer2.write("Ala ma kotaaa" + '\n' );
        writer2.write("A Ania ma dwa koty");
        writer2.close(); // inaczej dane z bufora strumienia mozna dodac metoda .flush(), ktora zawiera sie w metodzie .close()
    }
}
