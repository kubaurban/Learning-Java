package on_files;

import extending.Cat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObiektyWPlikach { /* aby moc dokonac serializacji(zapisania obiektu do pliku) trzeba zaimplementowac w klasie
                                  obiektu interfejs Serializable ! */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Cat> lista = new ArrayList<>();
        File f = new File("tekst1.txt");

        Scanner scn = new Scanner(System.in);
        String temp;
        while (!(temp = scn.nextLine()).equals("exit")) {
            if (temp.equals("ls")) {
                for (Cat cat : lista) {
                    System.out.println(cat);
                }
            } else if (temp.equals("read")) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                lista = (List<Cat>) ois.readObject();
            } else if (temp.equals("write")) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(lista);
            } else{  /* jezeli zadna z powyzszych instrukcji, to zaloz ze tworzysz obiekt Cat i dodajesz do listy: */
                lista.add(new Cat(temp));
            }
        }
        scn.close();
    }
}
