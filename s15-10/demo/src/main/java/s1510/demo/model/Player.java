package s1510.demo.model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Player extends UserEntity {

    private List<String> awards;
}
