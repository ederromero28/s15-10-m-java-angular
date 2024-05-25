package s1510.demo.dtos.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import s1510.demo.model.Sport;

import java.time.LocalDateTime;


public record MatchResponseDto(
        LocalDateTime startAt,

        LocalDateTime endAt,

        Integer pointsTeamA,

        Integer pointsTeamB,

        Sport sport) {

}
