package edu.wctc.dao;

import edu.wctc.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAOImpl implements MovieDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Movie> getMovies() {
        Session session = sessionFactory.getCurrentSession();

        List<Movie> list = session.createQuery("from Movie", Movie.class).getResultList();

        return list;
    }

    @Override
    public void saveMovie(Movie aMovie) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(aMovie);
    }

    @Override
    public Movie getMovie(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Movie.class, id);
    }

    @Override
    public void deleteMovie(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Movie where id = :doomedMovieId");
        query.setParameter("doomedMovieId", id);

        query.executeUpdate();
    }

    @Override
    public List<Movie> getMoviesByName(String searchTerm) {
        Session session = sessionFactory.getCurrentSession();

        Query<Movie> query = session.createQuery("from Movie where lower(movie_nm) like :searchTerm");
        searchTerm = "%" + searchTerm.toLowerCase() + "%";
        query.setParameter("searchTerm", searchTerm);

        return query.getResultList();
    }
}
