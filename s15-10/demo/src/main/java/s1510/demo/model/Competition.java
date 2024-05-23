package s1510.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "competition")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private int size;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Award awards;
    private Stage stages;
}
