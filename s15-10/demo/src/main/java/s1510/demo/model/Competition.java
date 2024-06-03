package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COMPETITIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "stage_size")
    private Integer stageSize;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "date_end")
    private LocalDate dateEnd;
    @OneToMany
    private Set<Award> awards;
    @OneToMany
    private List<Stage> stages;
}
