package hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movie_genre")
public class MovieGenre {
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "genre_id")
    private int genreId;
}
