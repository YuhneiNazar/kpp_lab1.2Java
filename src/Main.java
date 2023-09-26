import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Клас для представлення композиції
class Composition {
    private String title;
    private String genre;
    private String artist;
    private String lyrics;
    private java.util.Date creationDate;
    private java.time.Duration duration;
    private String format;
    private double rating;

    public Composition(String title, String genre, String artist, String lyrics, java.util.Date creationDate, java.time.Duration duration, String format, double rating) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.lyrics = lyrics;
        this.creationDate = creationDate;
        this.duration = duration;
        this.format = format;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public java.time.Duration getDuration() {
        return duration;
    }

    public String getFormat() {
        return format;
    }

    public double getRating() {
        return rating;
    }
}

// Клас-контейнер для композицій
class CompositionCollection<T extends Composition> extends ArrayList<T> {
    public void addComposition(T composition) {
        this.add(composition);
    }

    public void sortByTitle() {
        Collections.sort(this, Comparator.comparing(Composition::getTitle));
    }

    public void sortByArtist() {
        Collections.sort(this, Comparator.comparing(Composition::getArtist));
    }

    public void sortByAverageRating() {
        Collections.sort(this, Comparator.comparingDouble(Composition::getRating));
    }
}

// Клас утиліт для обробки контейнерів об'єктів
class CompositionUtility {
    public static <T extends Composition> void showCompositions(CompositionCollection<T> collection) {
        for (T composition : collection) {
            System.out.println("Назва: " + composition.getTitle());
            System.out.println("Жанр: " + composition.getGenre());
            System.out.println("Виконавець: " + composition.getArtist());
            System.out.println("Дата створення: " + composition.getCreationDate());
            System.out.println("Тривалість: " + composition.getDuration());
            System.out.println("Формат: " + composition.getFormat());
            System.out.println("Рейтинг: " + composition.getRating());
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CompositionCollection<Composition> compositionCollection = new CompositionCollection<>();

        compositionCollection.addComposition(new Composition("Пісня 1", "Рок", "Виконавець 3", "Текст пісні 1", new java.util.Date(), java.time.Duration.ofMinutes(3), "MP3", 4.5));
        compositionCollection.addComposition(new Composition("Пісня 3", "Поп", "Виконавець 2", "Текст пісні 3", new java.util.Date(), java.time.Duration.ofMinutes(4), "WAV", 3.8));
        compositionCollection.addComposition(new Composition("Пісня 2", "Реп", "Виконавець 1", "Текст пісні 2", new java.util.Date(), java.time.Duration.ofMinutes(5), "MP3", 4.2));

        compositionCollection.sortByTitle();
        System.out.println("Сортування за назвою:");
        CompositionUtility.showCompositions(compositionCollection);

        compositionCollection.sortByArtist();
        System.out.println("Сортування за виконавцем:");
        CompositionUtility.showCompositions(compositionCollection);

        compositionCollection.sortByAverageRating();
        System.out.println("Сортування за середнім рейтингом:");
        CompositionUtility.showCompositions(compositionCollection);
    }
}
