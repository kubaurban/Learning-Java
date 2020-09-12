package interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWritingInterface implements Interfejs { /*to klasa implementujaca interface (nadajaca ciala jego metodom)
    w klasie gdzie zaimplementowalismy interface musza byc zdefiniowane wszystkie jego metody.
    Ta klasa tworzy rzeczywisty obiekt interfejsu, a wiec zawiera implementacje jego metod*/
    @Override
    public void log(String text) throws FileNotFoundException { //tutaj podany tekst bedzie zapisywany do pliku
        File file = new File("tekst3.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print(text);
        writer.close();
    }

}
