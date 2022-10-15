package interfaces;

import java.io.FileNotFoundException;

public interface Interfejs {
    /*interface sluzy do przechowywania samych deklaracji metod, bez cial. Mowi klasom implementujacym co(, ale nie jak) maja robic.
    Zeby zaimplementowac interface do class - patrz interfaces.file_writing_interfejs
    w interfejsie wszytsko jest publiczne! */
    void log(String tekst) throws FileNotFoundException;
    default int domyslna() { /* interfejsy moga zawierac metody domyslne, zawierajace implementacje. Klasy implementujace nie musza
                             jej implementowac */
        return 0;
    }
}
