package on_files.strumienie_znakowe;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    /**
    Do pisania i czytania z plików używamy klas BufferedReader, FileReader, FileWriter, PrintWriter.
     */
    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("tekst.txt"); // deklaracja typu File istniejacego pliku, bez jego tworzenia!

        /* sciezka z ktorej jest czytany plik, tylko w takiej moge go umiescic
        zeby zostal przeczytany */
        System.out.println(plik.getAbsolutePath());

        //  odczyt:  //
        System.out.println(plik.exists()); // sprawdza istnienie mojego pliku

        /* Scanner vs. BufferedReader:
         * 1. Scanner może parsować input przez nextInt(), nextLong(), nextShort(), nextFloat(), nextDouble(),
         *    natomiast BufferedReader czyta tylko do String.
         * 2. BufferedReader ma większy bufor - może czytać większy String.
         * 3. Scanner może używać wyrażeń regularnych. (?)
         * 4. BufferedReader wspiera wielowątkowość.
         */
        Scanner odczyt = new Scanner(plik);
        while (odczyt.hasNext()) { // nazwa_scannera.hasNext() - sprawdza czy Scanner ma cos nastepnego do przeczytania
            String line = odczyt.nextLine();
            System.out.println(line);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(plik))) { // ten sam efekt, FileReader czyta plik binarnie
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
