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
public class Player extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> awards;
    private String phone;
    private String contactEmail;

    public Player(String email, String password,Boolean isPresent, String name, List<String> awards, String phone, String contactEmail){
        super(email,password,Role.PLAYER, isPresent ,name);
        this.awards = awards;
        this.phone = phone;
        this.contactEmail = contactEmail;
    }

    public Player() {
    }
}
