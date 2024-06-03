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
@Table(name = "PLAYERS")
public class Player implements Serializable {

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
    @Column(name = "phone")
    private String phone;
    @Column(name = "contact_email")
    private String contactEmail;
    @OneToMany
    private List<Award> awards = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private ImageEntity image;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamManager teamManager;

    public Player(String email,
                  String password,
                  Boolean isPresent,
                  String name,
                  String phone,
                  String contactEmail,
                  List<Award> awards,
                  ImageEntity image,
                  TeamManager teamManager) {

        this.email = email;
        this.password = password;
        this.role = Role.PLAYER;
        this.isPresent = isPresent;
        this.name = name;
        this.phone = phone;
        this.contactEmail = contactEmail;
        this.awards = awards;
        this.image = image;
        this.teamManager = teamManager;

    }

}
