package s1510.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Match {
    Date startAt;
    Date endAt;
    Integer pointsTeamA;
    Integer pointsTeamB;
    Sport sport;
}
