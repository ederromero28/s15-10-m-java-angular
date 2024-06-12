package s1510.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;
import s1510.demo.enums.StageType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Profile(value = {"dev", "prod", "test"})
@Table(name = "STAGES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stage_type")
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private StageType stageType;
//    @ManyToOne
//    @JoinColumn(name = "competition_id", referencedColumnName = "id")
//    private Competition competitionReference;
    // 1 Stage puede tener muchos Matchs
    @OneToMany()
    @JsonIgnore
    private List<Match> matchs = new ArrayList<>();
    @Column(name = "winner")
    @JsonIgnore
    private String winner;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    @JsonIgnore
    private TeamManager teamB;
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    @JsonIgnore
    private TeamManager teamA;
}
