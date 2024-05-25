package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import s1510.demo.enums.Role;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToMany
    private List<Award> awards;
    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private ImageEntity image;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamManager teamManager;
    @Column(name = "phone")
    private String phone;
    @Column(name = "contact_email")
    private String contactEmail;

   /* public Player(String email, String password,Boolean isPresent, String name,List<Award> awards, String phone, String contactEmail){
        super(email,password,Role.PLAYER, isPresent ,name);
        this.awards = awards;
        this.phone = phone;
        this.contactEmail = contactEmail;
    }*/

}
