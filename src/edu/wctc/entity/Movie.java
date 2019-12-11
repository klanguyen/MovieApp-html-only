package edu.wctc.entity;

import edu.wctc.entity.FeaturedCrew;
import edu.wctc.entity.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "movie_nm")
    private String name;

    @Column(name = "overview")
    private String overview;

    /**Cascade everything except deletes
     * because it shouldn't delete a movie
     * when a person in featured crew is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="movie_featuredcrew",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="featuredcrew_id"))
    private List<FeaturedCrew> featuredCrewList;

    /**Cascade everything except deletes
     * because it shouldn't delete a movie
     * when a genre is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="movie_genre",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genres;

    public Movie(){
        // no-arg constructor
    }

    public Movie(String name, String overview) {
        this.name = name;
        this.overview = overview;
    }

    public void add(FeaturedCrew tempFeaturedCrew){
        if(featuredCrewList == null) {
            featuredCrewList = new ArrayList<>();
        }
        featuredCrewList.add(tempFeaturedCrew);
    }

    public List<FeaturedCrew> getFeaturedCrewList() {
        return featuredCrewList;
    }

    public void setFeaturedCrewList(List<FeaturedCrew> featuredCrewList) {
        this.featuredCrewList = featuredCrewList;
    }

    public void add(Genre tempGenre) {
        if(genres == null) {
            genres = new ArrayList<>();
        }
        genres.add(tempGenre);
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
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

    @Override
    public String toString(){
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}