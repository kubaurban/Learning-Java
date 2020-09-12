package Enum;

public enum MovieCategory2 {

    HORROR("Horror"){
        @Override
        boolean isCool() {
            return true;
        }
    }, /* W tym przypadku wykorzystujemy juz nie konstruktor domyslny, a korzystajacy z parametru String,
                                 dlatego przy deklarowaniu wartosci Enuma musze zapisac je podajac takze parametr z konstruktora */
    SCI_FI("Science Fiction"){
        @Override
        boolean isCool() {
            return true;
        }
    },
    ROMANTIC("Romantyczny"){
        @Override
        boolean isCool() {
            return false;
        }
    };

    private String displayName; // Enum moze posiadac wlasne pola

    MovieCategory2(String displayName) { //wszystko w Enumie jest private DOMYSLNIE i nie moze byc inne
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() { /* tutaj nadpisana funkcja .toString() zwraca nazwe wartosci, czyli np. "HORROR", czy "SCI_FI",
                               ale w rzeczywistosci jest zbedna, bo robi tyle co sama domyslana funkcja .name() */
        return name();
    }

    abstract boolean isCool(); // w Enumie moga znajdowac sie tez abstrakcyjne metody, jednak ich implementacja musi znajdowac sie przy wartosciach Enuma (patrz wyzej na wartosci i rozwin {...})
}
