package extending;

public class Dog extends Animal {
    private String rasa;

    public Dog(int weight, int age, String rasa) {
        super(weight, age);
        this.rasa = rasa;
    }

    @Override
    public void speak() {
        super.speak();
        System.out.println("Hau!");
    }
}