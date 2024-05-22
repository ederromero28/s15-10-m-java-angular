package s1510.demo.model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import s1510.demo.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class UserEntity {

    private String email;
    private String password;
    private Role role;
    private Boolean isPresent;
    private String name;
}
