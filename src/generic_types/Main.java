package generic_types;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new OrderedElement<>(1, "jabłko");
        Pair<Integer, String> p2 = new OrderedElement<>(2, "gruszka");

        boolean same = Util.<Integer, String>compare(p1, p2); // ewentualnie: boolean same = Util.compare(p1, p2);

        if(same){
            System.out.println(p1 + " is the same as " + p2);
        }
        else {
            System.out.println(p1 + " is NOT the same as " + p2);
        }
    }
}
