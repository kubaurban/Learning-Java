package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc2_FileNotFound {
    public static void main(String[] args) throws IOException {
                                  // IOExceptions - zwiazane z wejsciem/wyjsciem, dziedz. z Exception, nalezy je obsluzyc!
        File file = new File("time.txt");
        try {
            Scanner scanner = new Scanner(file); // proba odczytania z nieistniejacego pliku
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // wyswietla drzewo wyjatkow ktore zostaly obsluzone
            System.out.println(e.getMessage()); // exception.getMessage() - zwraca informacje odnosnie obsluzonego wyjatku
            System.out.println("Nie ma takiego pliku");
        }

        FileWriter writer = new FileWriter(file); // wyrzuca IOException
        writer.write("To tylko time");
        writer.close();
    }
}
