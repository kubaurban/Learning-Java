package extending;

import java.io.Serializable;

public class Cat extends Animal implements Serializable /*patrz uzycie Serializable w on_files/ObiektyWPlikach*/  {
    private String name;
    private String color;
    private int lives;
    private static final long serialVersionUID = 798167573965080201L; /* numer potrzebny do odczytu obiektu Cat z pliku, nadany
    tak, aby byl zgodny z serialVersionUID klasy zserializowanej (przepisany po wyskoczeniu bledu) */

    @Override // adnotacja informujaca programiste, ze ponizsza metoda przeslania metode z klasy nadrzednej
    public void speak() {
        super.speak(); // super.* - wywołanie metody * klasy nadrzędnej
        System.out.println("Miau!");
    }

    public Cat(){}

    public Cat(int age, int weight, String name, String color, int lives) {
        super(age,weight); // super() - wywołanie konstruktora klasy nadrzędnej
        this.name = name;
        this.color = color;
        this.lives = lives;
    }

    public Cat(String name){
        super(10,9);
        this.name = name;
        this.color = "zolty";
        this.lives = 10;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + getAge() +
                ", weight=" + getWeight() +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", lives=" + lives +
                '}';
    }
}
