package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int id;

    @Column(name = "description")
    private String description;

    /**Cascade everything except deletes
     * because it shouldn't delete a position
     * when a person is deleted
     * Fetch type is lazy because it's the default type
     * of many-to-many mapping type **/
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JoinTable(name="featuredcrew_position",
            joinColumns = @JoinColumn(name="position_id"),
            inverseJoinColumns = @JoinColumn(name="featuredcrew_id"))
    private List<FeaturedCrew> featuredCrewList;

    public Position() {
        // no-arg constructor
    }

    public Position(String description) {
        this.description = description;
    }

    public void add(FeaturedCrew tempFeaturedCrew) {
        if(featuredCrewList == null) {
            featuredCrewList = new ArrayList<>();
        }
        featuredCrewList.add(tempFeaturedCrew);
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

    public List<FeaturedCrew> getFeaturedCrewList() {
        return featuredCrewList;
    }

    public void setFeaturedCrewList(List<FeaturedCrew> featuredCrewList) {
        this.featuredCrewList = featuredCrewList;
    }

    @Override
    public String toString(){
        return "Position{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
