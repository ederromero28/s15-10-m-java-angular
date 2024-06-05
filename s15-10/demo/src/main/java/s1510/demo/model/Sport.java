package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.util.List;

@Entity
@Profile(value = {"dev", "prod", "test"})
@Table(name = "SPORTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sport implements Serializable {

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