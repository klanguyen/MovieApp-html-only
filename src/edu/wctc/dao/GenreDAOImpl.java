package edu.wctc.dao;

import edu.wctc.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class GenreDAOImpl implements GenreDAO {
    @Autowired
    private GenreDAO genreDAO;

    @Override
    @Transactional
    public List<Genre> getGenres() {
        return genreDAO.getGenres();
    }

    @Override
    @Transactional
    public Genre getGenre(int id) {
        return genreDAO.getGenre(id);
    }
}
