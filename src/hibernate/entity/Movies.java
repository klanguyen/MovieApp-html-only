package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "movie_nm")
    private String name;

    @Column(name = "overview")
    private String overview;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "featuredcrew_id")
    private FeaturedCrew featuredCrew;

    public Movies(){
        // no-arg constructor
    }

    public Movies(String name, String overview) {
        this.name = name;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public FeaturedCrew getFeaturedCrew() {
        return featuredCrew;
    }

    public void setFeaturedCrew(FeaturedCrew featuredCrew) {
        this.featuredCrew = featuredCrew;
    }

    @Override
    public String toString(){
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", featuredCrew=" + featuredCrew +
                '}';
    }
}
