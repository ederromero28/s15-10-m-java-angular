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
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private StageType stageType;
//    @ManyToOne
//    @JoinColumn(name = "competition_id", referencedColumnName = "id")
//    private Competition competitionReference;
    // 1 Stage puede tener muchos Matchs
    @JsonIgnore
    @OneToMany()
    private List<Match> matchs = new ArrayList<>();
    @JsonIgnore
    @Column(name = "winner")
    private String winner;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "team_a_id")
    private TeamManager teamA;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private TeamManager teamB;
}
