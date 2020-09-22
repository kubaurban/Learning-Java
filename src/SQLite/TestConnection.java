package SQLite;

import java.util.List;

public class TestConnection { // we wzorcu projektowym MVC (Model - View - Controller) jest to Controller
    public static void main(String[] args) {
        DBConnector.getOnlyInstance();
        PeopleDAO peopleDAO = new PeopleDAO();
        // peopleDAO.createStructures();
        peopleDAO.createStructures(true,"osoby","ID","name","surname","email","tel_number");
        // peopleDAO.addContact("Jakub", "Nowak","jano@wp.pl" , "111222333");
        // peopleDAO.addContact("Anna", "Drozd", "emailadress@gmail.com", "333222111");
        List<Person> ls = peopleDAO.allPeople();
        for (Person l : ls) {
            System.out.println(l.toString());
        }
        System.out.println("\n"+"Osoby o imieniu Anna:");
        ls = peopleDAO.getResults("name","Anna");
        for (Person l : ls) {
            System.out.println(l.toString());
        }
        ls = peopleDAO.getResults("ID", 2);
        System.out.println("\n"+"Osoba o ID = 2:");
        for (Person l : ls) {
            System.out.println(l.toString());
        }
    }
}

