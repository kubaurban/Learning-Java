public class SwitchModif {
    public static void main(String[] args) {
        String season = "Winter";
        String translation = switch (season) {
            case "Spring" -> "wiosna"; // zamiast "->" można użyć "yield"
            case "Summer" -> "lato";
            case "Autumn" -> "jesień";
            case "Winter" -> "zima";
            default -> "nieznany";
        };
        System.out.println(translation);
    /*
    Modyfikatory pętli:
    break – całkowicie przerywa wykonywanie pętli
    continue – przechodzi do następnego przebiegu pętli
    */
    }
}
