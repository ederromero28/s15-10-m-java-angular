package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import s1510.demo.enums.StageType;

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
//    private Match[] matchs;
    @Column(name = "winner")
    private String winner;
//    private Team teamA;
//    private Team teamB;
}
