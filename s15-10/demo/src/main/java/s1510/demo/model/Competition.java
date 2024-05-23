package s1510.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import s1510.demo.enums.Award;

import java.time.LocalDate;

public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int size;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Award awards;
    private Stage stages;
}
