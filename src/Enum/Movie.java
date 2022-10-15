package Enum;

public class Movie {
    private String title;
    private String stringMovieCategory;
    private MovieCategory enumMovieCategory;

    public String getTitle() {
        return title;
    }

    public String getStringMovieCategory() {
        return stringMovieCategory;
    }

    public MovieCategory getEnumMovieCategory() {
        return enumMovieCategory;
    }

    public Movie(String title, String stringMovieCategory) {
        this.title = title;
        this.stringMovieCategory = stringMovieCategory;
    }

    public Movie(String title, MovieCategory enumMovieCategory) {
        this.title = title;
        this.enumMovieCategory = enumMovieCategory;
    }

}
