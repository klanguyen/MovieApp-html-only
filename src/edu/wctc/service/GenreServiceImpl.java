package edu.wctc.service;

import edu.wctc.dao.*;
import edu.wctc.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
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
