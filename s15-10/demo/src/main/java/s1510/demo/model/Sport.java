package s1510.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sport")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer teamSize;
    private Integer rounds;

    private Boolean status = true;

}