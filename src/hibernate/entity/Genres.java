package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "description")
    private String description;

    public Genres() {
        // no-arg constructor
    }

    public Genres(String description) {
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
        return "Genres{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
