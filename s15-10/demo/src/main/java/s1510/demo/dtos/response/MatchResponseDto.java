package s1510.demo.dtos.response;


import org.springframework.context.annotation.Profile;
import s1510.demo.model.Sport;

import java.time.LocalDateTime;

@Profile(value = {"dev", "prod", "test"})
public record MatchResponseDto(
        LocalDateTime startAt,

        LocalDateTime endAt,

        Integer pointsTeamA,

        Integer pointsTeamB,

        Sport sport) {

}
