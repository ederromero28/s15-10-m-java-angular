package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import s1510.demo.enums.Role;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
public class TeamManager extends UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    private ImageEntity logo;
    @OneToMany
    private List<Award> awards;
    @OneToMany
    private List<Player> players;

    public TeamManager(String email, String password, Boolean isPresent, String name, List<Player> players){
        super(email,password, Role.TEAM_MANAGER, isPresent ,name);
        this.players = players;
    }

}
