//using ui-directional
package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "featuredcrew")
public class FeaturedCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "featuredcrew_id")
    private int featuredCrewId;

    @Column(name = "name")
    private String name;

    /**Cascade everything except deletes
     * because it shouldn't delete a person in featured crew
     * when a position is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH})
    @JoinTable(name="featuredcrew_position",
            joinColumns = @JoinColumn(name="featuredcrew_id"),
            inverseJoinColumns = @JoinColumn(name="position_id"))
    private List<Position> positions;

    /**Cascade everything except deletes
     * because it shouldn't delete a person in featured crew
     * when a movie is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="movie_featuredcrew",
            joinColumns = @JoinColumn(name="featuredcrew_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;

    public FeaturedCrew() {
        // no-arg constructor
    }

    public FeaturedCrew(String name) {
        this.name = name;
    }

    public void add(Position tempPosition) {
        if (positions == null) {
            positions = new ArrayList<>();
        }
        positions.add(tempPosition);
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public void add(Movie tempMovie) {
        if (movies == null) {
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

    public int getFeaturedCrewId() {
        return featuredCrewId;
    }

    public void setFeaturedCrewId(int featuredCrewId) {
        this.featuredCrewId = featuredCrewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "FeaturedCrew{" +
                "id=" + featuredCrewId +
                ", name='" + name + '\'' +
                '}';
    }
}
