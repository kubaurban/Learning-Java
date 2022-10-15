package abstract_classes;

public class Babcia extends Emeryt {

    @Override
    public String krzyczNaDzieci() {
        return "Spadowa spod mojego okna";
    }

}

class swiat {
    public static void main(String[] args) {
        Emeryt Krystyna = new Babcia();
        System.out.println(Krystyna.krzyczNaDzieci());
    }
}

// klasy abstrakcyjne a interfejsy: https://devcave.pl/effective-java/interfejsy-vs-klasy-abstrakcyjne