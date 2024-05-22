package s1510.demo.model;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TeamManager extends UserEntity{


    private Player[] players;
}
