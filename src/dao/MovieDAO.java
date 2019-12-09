package dao;

import hibernate.entity.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getMovies();

    void saveMovie(Movie aMovie);

    Movie getMovie(int id);

    void deleteMovie(int id);

    List<Movie> getMoviesByName(String searchTerm);
}
