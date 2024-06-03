package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "sports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "team_size")
    private Integer teamSize;
    @Column(name = "rounds")
    private Integer rounds;
    @OneToMany
    private List<Match> match;
    @Column(name = "status")
    private Boolean status = true;

}