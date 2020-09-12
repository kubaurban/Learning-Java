package interfaces;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main { /* kiedy stosowac interface?
                       kiedy planujemy aby dane metody (ich nazwa, argumenty i typ zwracany lub implementacja)
                       powtarzaly sie kiedys dla jakiejs klasy */

    public static void main(String[] args) throws FileNotFoundException {
        Interfejs interfejs = new FileWritingInterface(); //tworze obiekt klasy implementujacej, zawierajacej metody w danym interfejsie
        Scanner scanner = new Scanner(System.in);
        String tekst = scanner.nextLine();
        interfejs.log(tekst);
    }

}
