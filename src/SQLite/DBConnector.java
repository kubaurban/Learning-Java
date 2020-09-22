package SQLite;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Aby polaczyc sie z baza danych Java wykorzystuje JDBC (Java DataBase Connectivity - czyli interfejs pozwalający na
 * ustanowienie połączenia do bazy danych z poziomu aplikacji napisanej w Javie) oraz pobrany sterownik (przeznaczony dla JDBC)
 * do odpowiedniej relacyjnej bazy danych (w tym wypadku korzystam z SQLite, a moj sterownik znajduje sie dokladnie tutaj:
 * "org.sqlite.JDBC").
 *
 * Klasa DBConnector odpowiada za łączenie się do bazy, rozłączanie i operacje CRUD (CRUD od ang. create, read, update and
 * delete - oznacza podstawowe operacje implementowane w aplikacjach bazodanowych, mogą być realizowane przez standardowe
 * instrukcje SQL, metody HTTP oraz operacje DDS). Tu wszystko zostało zapisane w jednej klasie, natomiast przy prawdziwym
 * projekcie oddzielamy connector od DAO (DAO z ang. Data Access Object - (rowniez wzorzec projektowy) komponent dostarczający
 * interfejs do komunikacji między aplikacją, a źródłem danych np. bazą danych. Jest to miejsce wymiany danych między naszą
 * aplikacją, a źródłem danych), i najlepiej byłoby, aby każda encja (tutaj dla uproszczenia = tabela w bazie danych) miała
 * swoje DAO.
 * */
public class DBConnector {
    private Connection con; /* obiekt interfejsu Connection (w skrocie, a tak naprawde obiekt klasy implementujacej Connection o nazwie SQLiteConnection - zawarty w pobranym sterowniku). Odpowiada m.in. za utworzenie polaczenia miedzy baza danych, a aplikacja.*/
    private Statement stat; /* interfejs Statement jest uzywany do wprowadzania zwyklych komend SQL*/
    private static DBConnector onlyInstance;

    /**
     * Ponieważ potrzebujemy w aplikacji tylko jednego obiektu klasy DBConnector, korzystam ze wzorca projektowego Singleton
     * (w implementacji kontruktora oraz pisząc metodę statyczną .getOnlyInstance())
     */
    private DBConnector() { /* konstruktor tworzy polaczenie z baza i obiekt Statement pozwalajacy na wykonywanie zapytan sql
                          oraz stwarza (o ile nie istnieje tabele w bazie)*/
        try{
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Nie mam drivera JDBC");
            e.printStackTrace();
        }
        try{
            con = DriverManager.getConnection("jdbc:sqlite:contacts.db");
            /* tutaj tworzony jest obiekt klasy impl. Connection, ktory od razu laczy sie z serwerem bazy danych
            (adres url w parametrze metody) i od razu tworzy baze danych (contacts.db). Klasa DriverManager zarzadza
            sterownikami JDBC (DBConnector->DriverManager->JDBC(wejscie do sterownika)->SQLiteConnection). */
            stat = con.createStatement();
            /* tworzy obiekt klasy Statement, jako "skladowa" obiektu con, wykonujący wyrażenia sql za pomocą metody
            executeStatement(query) lub executeQuery(query) */
        } catch (SQLException throwables) {
            System.err.println("Nie moge utworzyc polaczenia");
            throwables.printStackTrace();
        }
        createStructures();
    }

    public static DBConnector getOnlyInstance() {
        if (onlyInstance == null) {
            onlyInstance = new DBConnector();
        }
        return onlyInstance;
    }

    public boolean createStructures(){ /* stwarza pierwsza tabele w bazie (o ile nie istnieje zadna) */
        String sql = "CREATE TABLE IF NOT EXISTS osoby"
                + "("
                + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name varchar(100), "
                + "surname varchar(100), "
                + "email varchar(100), "
                + "tel_number varchar(100)"
                + ")";
        try{
            stat.execute(sql); /* polecenie .execute(polecenie_sql_String) na obiekcie klasy Statement wykona polecenie sql
                               podane w parametrze odnosnie bazy danych ktora z aplikacja zwiazana jest polaczeniem con*/
        } catch (SQLException throwables) {
            System.err.println("Problem przy tworzeniu struktur");
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addContact(String name, String surname, String email, String tel_number) {
        try{
            PreparedStatement pStmt = con.prepareStatement( /* interfejs PreparedStatement - uzywany do wprowadzania
                                                            dynamicznych lub zparametryzowanych komend SQL, powstaje
                                                            analogicznie jak obiekt klasy Statement, z ta roznica, ze
                                                            w parametrze od razu musimy zadeklarowac polecenie sql*/
                    "insert into osoby values (NULL, ?, ?, ?, ?);"
                    /* wartosc NULL jako pierwszy parametr pojawia sie tam poniewaz pierwsza kolumna w tabeli posiada ceche
                    AUTOINCREMENT, cztery znaki zapytania (?) zastepuja parametry, ktore podawane sa dynamicznie ponizej: */
            );
            pStmt.setString(1, name); // ponizsze uzycia funkcji .setString(nr_parametru, wartosc_parametru)
            pStmt.setString(2, surname); // dynamicznie uzupelniaja znaki ? uzyte w deklaracji obiektu PreparedStatement
            pStmt.setString(3, email);
            pStmt.setString(4, tel_number);
            pStmt.execute(); // jednak zmiany zostana wdrozone dopiero po uzyciu funkcji .execute() na obiekcie PreparedStatement
        } catch (SQLException throwables) {
            System.err.println("Błąd przy dodawaniu kontaktu");
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Person> allPeople(){
        List<Person> people = new LinkedList<>();
        try{
            ResultSet result = stat.executeQuery("SELECT * FROM osoby");/*obiekt klasy ResultSet przechowuje wynik
            zapytania/kwerendy (query) SQL, umozliwia takze poruszanie sie po tym wyniku, domyslnie wskazujac
            na wiersz/rekord tuz przed pierwszym istniejacym*/
            int id;
            String name;
            String surname;
            String email;
            String tel_number;
            while (result.next()) { /* funkcja .next() przesuwa "wskaznik" na kolejny rząd/rekord w tabeli, domyslnie jest
                                    ustawiony na jeden rekord przed pierwszym wlasciwym. Dodatkowo zwraca booleana czy
                                    istnieje kolejny rekord do wskazania */
                id = result.getInt("ID"); /* funkcja .getTYP_DANYCH(*) wydobywa odpowiedni typ danych z rekordu
                                                        na ktory obecnie wskazuje wskaznik obiektu result. W parametrze *
                                                        moze przyjac zarowno indeks kolumny z jakiej nalezy pobrac wynik
                                                        albo nazwe danej kolumny */
                name = result.getString("name");
                surname = result.getString("surname");
                email = result.getString("email");
                tel_number = result.getString("tel_number");
                people.add(new Person(id, name, surname, email, tel_number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return people;
    }

    public List<Person> getResults(String columnLabel, int warunek) {
        List<Person> people = new LinkedList<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM osoby WHERE " + columnLabel + " = " + warunek);
            int id;
            String name;
            String surname;
            String email;
            String tel_number;
            while (result.next()) {
                id = result.getInt("ID");
                name = result.getString("name");
                surname = result.getString("surname");
                email = result.getString("email");
                tel_number = result.getString("tel_number");
                people.add(new Person(id, name, surname, email, tel_number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public List<Person> getResults(String columnLabel, String warunek) {
        List<Person> people = new LinkedList<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM osoby WHERE " + columnLabel + " = \"" + warunek + "\"");
            int id;
            String name;
            String surname;
            String email;
            String tel_number;
            while (result.next()) {
                id = result.getInt("ID");
                name = result.getString("name");
                surname = result.getString("surname");
                email = result.getString("email");
                tel_number = result.getString("tel_number");
                people.add(new Person(id, name, surname, email, tel_number));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
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
