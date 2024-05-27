package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name="MATCHES")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime startAt;
    LocalDateTime endAt;
    Integer pointsTeamA;
    Integer pointsTeamB;
    @ManyToOne
    @JoinColumn(name = "sport_id", referencedColumnName = "id")
    Sport sport;
    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false // Siempre tiene que haber una entidad Stage asociado a esta entidad Match
    )
    @JoinColumn(name = "stage_id")
    private Stage stage;
}
