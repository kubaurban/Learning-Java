package wzorzec_Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getOnlyInstance(); // wywolanie metody statycznej, bez tworzenia obiektu
        Singleton s2 = Singleton.getOnlyInstance();
        System.out.println("Dowod: " + s1 + " == " +s2);
    }
}
