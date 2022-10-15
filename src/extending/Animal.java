package extending;

public class Animal {
    protected int weight; // protected daje dostep do skladowej wszystkim klasom dziedziczacym
    private int age;
    public void speak(){
        System.out.println("ARRRR!");
    }

    public Animal(int weight, int age) {
        this.weight = weight; // this oznacza Obiekt na którym wywoływana jest dana metoda
        this.age = age;
    }
    public Animal(){}

    public final void poluj() { // modyfikator final uzyty przed metoda uniemozliwia jej nadpisane w klasach dziedziczacych
        System.out.println("Poluje");
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
