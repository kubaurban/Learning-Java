package SQLite;

import java.sql.*;
import java.util.Properties;

/**
 * Aby polaczyc sie z baza danych Java wykorzystuje JDBC (Java DataBase Connectivity - czyli interfejs pozwalający na
 * ustanowienie połączenia do bazy danych z poziomu aplikacji napisanej w Javie) oraz pobrany sterownik (przeznaczony dla JDBC)
 * do odpowiedniej relacyjnej bazy danych (w tym wypadku korzystam z SQLite, a moj sterownik znajduje sie dokladnie tutaj:
 * "org.sqlite.JDBC").
 *
 * Klasa DBConnector odpowiada za łączenie się do bazy i rozłączanie z nią.
 * Przy każdym prawdziwym projekcie oddzielamy connector (DBConnector) od DAO (PeopleDAO).
 * */
public class DBConnector {
    private static Connection con; /* obiekt interfejsu Connection (w skrocie, a tak naprawde obiekt klasy implementujacej Connection
                            o nazwie SQLiteConnection - zawarty w pobranym sterowniku). Odpowiada m.in. za utworzenie
                            polaczenia miedzy baza danych, a aplikacja.*/
    private static DBConnector onlyInstance;

    /**
     * Tworzy obiekt klasy DBConnector.
     * Ponieważ potrzebujemy w aplikacji tylko jednego obiektu klasy DBConnector, korzystam ze wzorca projektowego Singleton
     * (w implementacji kontruktora oraz pisząc metodę statyczną .getOnlyInstance())
     */
    private DBConnector() { /* konstruktor tworzy polaczenie z baza i obiekt Statement pozwalajacy na wykonywanie zapytan sql
                          oraz stwarza (o ile nie istnieje tabele w bazie)*/
        Driver d = new org.sqlite.JDBC(); /* recznie tworzymy sterownik, zamiast sprawdzac jego istnienie */
        Properties props = new Properties(); /* deklaracja obiektu Properties, majacego za zadanie przechowywanie wlasciwosci*/
        props.getProperty("user", "mikey");
        props.getProperty("password", "mouse");

        try{
            con = d.connect("jdbc:sqlite:contacts.db", props);/* funkcja connect() klasy Driver zwraca obiekt klasy Connection,
                                                                ktory od razu laczy sie z serwerem bazy danych (adres url
                                                                w parametrze metody) i od razu tworzy baze danych (contacts.db).*/
            /* W alternatywnej metodzie nawiazywania polaczenia (patrz commit "Simple structure of database application with
            usage of SQLite" z 13.09.2020 01:56) z baza danych tworzony jest obiekt klasy impl. Connection, a Klasa
            DriverManager zarzadza sterownikami JDBC (DBConnector->DriverManager->JDBC(wejscie do sterownika)->SQLiteConnection). */
        } catch (SQLException throwables) {
            System.err.println("Nie moge utworzyc polaczenia");
            throwables.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }

    public static DBConnector getOnlyInstance() {
        if (onlyInstance == null) {
            onlyInstance = new DBConnector();
        }
        return onlyInstance;
    }

    public void closeConnection(){
        try{
            con.close();
        } catch (SQLException throwables) {
            System.err.println("Błąd przy zamykaniu połączenia");
            throwables.printStackTrace();
        }
    }
}
