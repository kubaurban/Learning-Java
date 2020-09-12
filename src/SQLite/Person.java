package SQLite;

public class Person {
    private int ID;
    private String name;
    private String surname;
    private String email;
    private String tel_number;

    @Override
    public String toString() {
        return "Nr ID: " + ID
                + ", Imie: " + name
                + ", Nazwisko: " + surname
                + ", email: " + email
                + ", nr telefonu: " + tel_number;
    }

    public Person(int ID, String name, String surname, String email, String tel_number) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tel_number = tel_number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }
}
