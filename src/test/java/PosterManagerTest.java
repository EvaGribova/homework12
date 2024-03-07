import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.MovieItem;
import ru.netology.movies.PosterManager;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    MovieItem item1 = new MovieItem("Бладшот", "Боевик");
    MovieItem item2 = new MovieItem("Вперёд", "Мультфильм");
    MovieItem item3 = new MovieItem("Отель'Белград'", "Комедия");
    MovieItem item4 = new MovieItem("Джентльмены", "Боевик");
    MovieItem item5 = new MovieItem("Человек-невидимка", "Ужасы");
    MovieItem item6 = new MovieItem("Тролли. Мировой тур", "Мультфильм");
    MovieItem item7 = new MovieItem("Номер один", "Комедия");

    @Test
    public void shouldAddMovies() {

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);

        MovieItem[] expected = {item1, item2, item3, item4, item5, item6, item7};
        MovieItem[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMovies() {

        manager.addMovie(item1);
        manager.addMovie(item2);
        manager.addMovie(item3);
        manager.addMovie(item4);
        manager.addMovie(item5);
        manager.addMovie(item6);
        manager.addMovie(item7);

        MovieItem[] expected = {item7, item6, item5, item4, item3};
        MovieItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoviesWhithLimit() {

        PosterManager limitLastMovies = new PosterManager(3);
        limitLastMovies.addMovie(item4);
        limitLastMovies.addMovie(item5);
        limitLastMovies.addMovie(item6);
        limitLastMovies.addMovie(item7);
        limitLastMovies.addMovie(item3);
        limitLastMovies.addMovie(item2);

        MovieItem[] expected = {item2, item3, item7};
        MovieItem[] actual = limitLastMovies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMovieShoterLenght() {
        PosterManager limitLastMovies = new PosterManager();

        limitLastMovies.addMovie(item3);
        limitLastMovies.addMovie(item7);
        limitLastMovies.addMovie(item5);

        MovieItem[] expected = {item5, item7, item3};
        MovieItem[] actual = limitLastMovies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
