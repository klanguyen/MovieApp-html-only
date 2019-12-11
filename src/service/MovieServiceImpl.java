package service;

import dao.MovieDAO;
import hibernate.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieDAO movieDAO;

    @Override
    @Transactional
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }

    @Override
    @Transactional
    public void saveMovie(Movie aMovie) {
        movieDAO.saveMovie(aMovie);
    }

    @Override
    @Transactional
    public Movie getMovie(int id) {
        return movieDAO.getMovie(id);
    }

    @Override
    @Transactional
    public void deleteMovie(int id) {
        movieDAO.deleteMovie(id);
    }

    @Override
    @Transactional
    public List<Movie> getMoviesByName(String searchTerm) {
        return movieDAO.getMoviesByName(searchTerm);
    }
}
