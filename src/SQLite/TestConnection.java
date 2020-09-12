package SQLite;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        DBConnector d = new DBConnector();
        /*
        d.addContact("Jakub", "Nowak","jano@wp.pl" , "111222333");
        d.addContact("Anna", "Drozd", "emailadress@gmail.com", "333222111");
        */
        List<Person> ls = d.allPeople();
        for (Person l : ls) {
            System.out.println(l.toString());
        }
    }
}

