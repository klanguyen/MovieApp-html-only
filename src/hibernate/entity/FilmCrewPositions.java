package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "filmcrewpositions")
public class FilmCrewPositions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int id;

    @Column(name = "description")
    private String description;

    public FilmCrewPositions() {
        // no-arg constructor
    }

    public FilmCrewPositions(String description) {
        this.description = description;
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
        return "FilmCrewPositions{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
