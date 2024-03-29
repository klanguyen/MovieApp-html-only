package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "description")
    private String description;

    /**Cascade everything except deletes
     * because it shouldn't delete a genre
     * when a movie is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="movie_genre",
            joinColumns = @JoinColumn(name="genre_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;

    public Genre() {
        // no-arg constructor
    }

    public Genre(String description) {
        this.description = description;
    }

    public void add(Movie tempMovie) {
        if(movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(tempMovie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Genres{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
