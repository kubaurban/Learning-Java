package exceptions;

public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] tab = {1, 4, -3};
        try {
            System.out.println(tab[3]);
        }
        catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Niewłaściwy element tablicy");
        }
    }
}
