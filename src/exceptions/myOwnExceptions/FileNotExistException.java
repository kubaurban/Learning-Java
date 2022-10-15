package exceptions.myOwnExceptions;

public class FileNotExistException extends RuntimeException { // lub Exception (te trzeba dodawac do sygnatur metod wyrzucajacych je)
    public FileNotExistException(String msg) {
        super(msg); // wywolanie konstruktora klasy RuntimeException, wyswietlajacego message o tresci podanej w argumencie konstruktora mojego wyjatku
    }
}
