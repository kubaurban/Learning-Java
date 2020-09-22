package SQLite;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        DBConnector d = DBConnector.getOnlyInstance();
        // d.addContact("Jakub", "Nowak","jano@wp.pl" , "111222333");
        // d.addContact("Anna", "Drozd", "emailadress@gmail.com", "333222111");
        List<Person> ls = d.allPeople();
        for (Person l : ls) {
            System.out.println(l.toString());
        }
        System.out.println("\n"+"Osoby o imieniu Anna:");
        ls = d.getResults("name","Anna");
        for (Person l : ls) {
            System.out.println(l.toString());
        }
        ls = d.getResults("ID", 2);
        System.out.println("\n"+"Osoba o ID = 2:");
        for (Person l : ls) {
            System.out.println(l.toString());
        }
    }
}

