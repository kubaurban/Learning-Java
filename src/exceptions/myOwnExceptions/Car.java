package exceptions.myOwnExceptions;

public class Car{

    public class MechanicException extends Exception { /* z racji ze ten wyjatek jest scisle zwiazany tylko z ta klasa,
                                                          wygodnie jest go w niej umiescic */
        public MechanicException(String message) {
            super(message);
        }
    }

    private double ladownosc;

    public Car(double ladownosc) {
        this.ladownosc = ladownosc;
    }

    public double getLadownosc() throws MechanicException {
        if(ladownosc < 1000){
            throw new MechanicException("Zbyt niska ladownosc"); // oryginalny pomysl na wyrzucenie wlasnego wyjatku
        }
        return ladownosc;
    }
}

