package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;


import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Profile(value = {"dev", "prod", "test"})
@Table(name = "MATCHES")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "start_at")
    LocalDateTime startAt;
    @Column(name = "end_at")
    LocalDateTime endAt;
    @Column(name = "points_team_a")
    Integer pointsTeamA;
    @Column(name = "points_team_b")
    Integer pointsTeamB;
    @ManyToOne
    @JoinColumn(name = "sport_id", referencedColumnName = "id")
    Sport sport;
    @ManyToOne()
    @JoinColumn(name = "stage_id")
    private Stage stage;

}
