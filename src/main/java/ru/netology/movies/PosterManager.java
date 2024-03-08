package ru.netology.movies;

import ru.netology.data.MovieItem;

public class PosterManager {
    private int countFindLast = 5;
    private MovieItem[] movies = new MovieItem[0];

    public PosterManager(int findLast) {
        this.countFindLast = findLast;
    }

    public PosterManager() {
    }

    public MovieItem[] findAll() {
        return movies;
    }

    public void addMovie(MovieItem movie) {
        MovieItem[] tmp = new MovieItem[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieItem[] findLast() {
        MovieItem[] lastMovies;
        int resultLenght;

        if (countFindLast > movies.length) {
            resultLenght = movies.length;
        } else {
            resultLenght = countFindLast;
        }
        lastMovies = new MovieItem[resultLenght];
        for (int i = 0; i < resultLenght; i++) {
            lastMovies[i] = movies[movies.length - 1 - i];
        }
        return lastMovies;
    }
}
