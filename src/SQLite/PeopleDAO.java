package SQLite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Klasa PeopleDAO odpowiada za tzw. operacje CRUD (CRUD od ang. create, read, update and delete - oznacza podstawowe
 * operacje implementowane w aplikacjach bazodanowych, mogą być realizowane przez standardowe instrukcje SQL, metody HTTP
 * oraz operacje DDS).
 *
 * DAO (z ang. Data Access Object - rowniez wzorzec projektowy) to komponent dostarczający interfejs do komunikacji między
 * aplikacją, a źródłem danych np. bazą danych. Jest to miejsce wymiany danych między naszą aplikacją, a źródłem danych),
 * i najlepiej byłoby, aby każda encja (tutaj dla uproszczenia = tabela w bazie danych) miała swoje DAO.
 * */
public class PeopleDAO{

    private Statement stat = null; /* interfejs Statement jest uzywany do wprowadzania
                zwyklych komend SQL. Metoda .createStatement() tworzy obiekt klasy Statement, jako "skladowa" obiektu con
                (polaczenia z nasza baza danych), wykonujący wyrażenia sql za pomocą metody executeStatement(query)
                lub executeQuery(query)*/

    public PeopleDAO() {}

    /**
     * Stwarza tabele osoby w bazie (o ile nie istnieje zadna)
     * */
    public boolean createStructures(){
        try {
            stat = DBConnector.getCon().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
            stat.close();
        } catch (SQLException throwables) {
            System.err.println("Problem przy tworzeniu struktur");
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Stwarza tabele (o ile nie istnieje) o podanej nazwie i podanych kolumnach, o typie String i dlugosci max 100 znakow.
     * */
    public boolean createStructures(boolean autoincrement, String tableName, String ... columns) {
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sql.append(tableName).append("(");
        for (String column : columns) {
            if (autoincrement) {
                sql.append(column).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
                autoincrement = false;
                continue;
            }
            sql.append(column).append(" varchar(100), ");
        }
        sql.reverse().delete(0,2).reverse().append(")");

        try {
            stat = DBConnector.getCon().createStatement();
            stat.execute(sql.toString());
            stat.close();
        } catch (SQLException throwables) {
            System.err.println("Problem przy tworzeniu struktur");
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addContact(String name, String surname, String email, String tel_number) { // uodparniamy na SQL Injection
        try{
            PreparedStatement pStmt = DBConnector.getCon().prepareStatement( /* interfejs PreparedStatement - uzywany do
            wprowadzania dynamicznych lub zparametryzowanych komend SQL, powstaje analogicznie jak obiekt klasy Statement,
            z ta roznica, ze w parametrze od razu musimy zadeklarowac polecenie sql*/
                    "INSERT INTO osoby VALUES (NULL, ?, ?, ?, ?);"
                    /* wartosc NULL jako pierwszy parametr pojawia sie tam poniewaz pierwsza kolumna w tabeli posiada ceche
                    AUTOINCREMENT, cztery znaki zapytania (?) zastepuja parametry, ktore podawane sa dynamicznie ponizej: */
            );
            pStmt.setString(1, name); // ponizsze uzycia funkcji .setString(nr_parametru, wartosc_parametru)
            pStmt.setString(2, surname); // dynamicznie uzupelniaja znaki ? uzyte w deklaracji obiektu PreparedStatement
            pStmt.setString(3, email);
            pStmt.setString(4, tel_number);
            pStmt.execute(); // jednak zmiany zostana wdrozone dopiero po uzyciu funkcji .execute() na obiekcie PreparedStatement
            pStmt.close();
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
            stat = DBConnector.getCon().createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM osoby"); /*obiekt klasy ResultSet przechowuje wynik
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
            stat.close(); // zamyka takze powiazany ResultSet
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return people;
    }

    public List<Person> getResults(String columnLabel, int condition) {
        List<Person> people = new LinkedList<>();
        try {
            stat = DBConnector.getCon().createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM osoby WHERE " + columnLabel + " = " + condition);
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

    public List<Person> getResults(String columnLabel, String condition) {
        List<Person> people = new LinkedList<>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM osoby WHERE " + columnLabel + " = \"" + condition + "\"");
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


}
