package s1510.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Match implements Serializable {
    Long id;
    LocalDateTime startAt;
    LocalDateTime endAt;
    Integer pointsTeamA;
    Integer pointsTeamB;
    Sport sport;
}
