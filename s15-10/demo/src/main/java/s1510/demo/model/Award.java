package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

@Entity
@Profile(value = {"dev", "prod", "test"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AWARDS")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "competition")
    private String competition;
    @Column(name = "place")
    private String place;
    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competitionReference;
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamManager teamManager;
}
