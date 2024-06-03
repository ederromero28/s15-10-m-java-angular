package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;
import s1510.demo.enums.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Entity
@Profile(value = {"dev", "prod", "test"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEAM_MANAGERS")
public class TeamManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "is_present")
    private Boolean isPresent;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    private ImageEntity logo;
    @OneToMany
    private List<Award> awards = new ArrayList<>();
    @OneToMany
    private List<Player> players = new ArrayList<>();

    public TeamManager(String email,
                       String password,
                       Boolean isPresent,
                       String name,
                       ImageEntity logo,
                       List<Award> awards,
                       List<Player> players) {

        this.email = email;
        this.password = password;
        this.isPresent = isPresent;
        this.role = Role.TEAM_MANAGER;
        this.name = name;
        this.logo = logo;
        this.awards = awards;
        this.players = players;

    }

}
