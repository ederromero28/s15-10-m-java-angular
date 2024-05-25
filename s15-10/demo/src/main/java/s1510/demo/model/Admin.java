package s1510.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.*;
import s1510.demo.enums.Role;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Builder
@Table(name = "admins")
public class Admin extends UserEntity{

    public Admin(String email, String password,Boolean isPresent, String name){
        super(email,password, Role.ADMIN, isPresent,name);
    }

}
