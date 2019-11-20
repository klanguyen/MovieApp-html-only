//using ui-directional
package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "featuredcrew")
public class FeaturedCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "featuredcrew_id")
    private int featuredCrewId;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "name")
    private String name;

    @Column(name = "position_id")
    private int positionId;
}
