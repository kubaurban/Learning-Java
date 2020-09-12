package exceptions.myOwnExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            run();
        } catch (FileNotExistException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void run() {
        File file = new File("test2.txt");
        if (file.exists()){
            try {
                Scanner scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new FileNotExistException("Nie ma takiego pliku");
            }
        } else{
            throw new FileNotExistException("Nie ma takiego pliku");       // wyrzucam swoj wyjatek
        }

    }
}

