package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import s1510.demo.enums.StageType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stage")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stageType")
    private StageType stageType;
    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competitionReference;
    // 1 Stage puede tener muchos Matchs
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Match> matchs = new ArrayList<>();
    @Column(name = "winner")
    private String winner;
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private TeamManager teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private TeamManager teamB;
}
