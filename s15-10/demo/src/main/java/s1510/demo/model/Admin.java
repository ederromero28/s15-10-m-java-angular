package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Profile;
import s1510.demo.enums.Role;

import java.io.Serializable;

@EqualsAndHashCode
@Entity
@Profile(value = {"dev", "prod", "test"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ADMINS")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Admin(String email, String password, Boolean isPresent, String name) {
        this.email = email;
        this.password = password;
        this.role = Role.ADMIN;
        this.isPresent = isPresent;
        this.name = name;
    }

}
