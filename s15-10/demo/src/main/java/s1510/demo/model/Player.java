package s1510.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Player extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> awards;
}
