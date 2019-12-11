package edu.wctc.service;

import edu.wctc.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {
    List<Movie> getMovies();

    void saveMovie(Movie aMovie);

    Movie getMovie(int id);

    void deleteMovie(int id);

    List<Movie> getMoviesByName(String searchTerm);
}
