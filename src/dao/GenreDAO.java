package dao;

import hibernate.entity.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();

    Genre getGenre(int id);
}
