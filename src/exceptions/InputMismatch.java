package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Podaj liczbę");
        int liczba = 0;
        try {
            liczba = x.nextInt();
        } catch (InputMismatchException a) {
            System.out.println("Nie liczba");
            return; //kończy program (nie wyświetla "Liczba to 0")
        }
        System.out.println("Liczba to "+liczba);
    }
}
