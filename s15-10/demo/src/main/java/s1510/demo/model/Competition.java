package s1510.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Profile(value = {"dev", "prod", "test"})
@Table(name = "COMPETITIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Competition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "stage_count")
    private Integer stageCount;
    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "date_end")
    private LocalDate dateEnd;
    @OneToMany
    @JsonIgnore
    private Set<Award> awards;
    @OneToMany
    private List<Stage> stages = new ArrayList<>();

    public void addStage(Stage stage) {
        stages.add(stage);
    }
}
