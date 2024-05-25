package s1510.demo.dtos.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import s1510.demo.model.Sport;

import java.time.LocalDateTime;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public record MatchResponseDto( @NotNull(message = "La fecha de inicio no puede ser nula")
                                LocalDateTime startAt,
                                @NotNull(message = "La fecha de finalización no puede ser nula")
                                LocalDateTime endAt,
                                @NotNull(message = "Los puntos del equipo A no pueden ser nulos")
                                Integer pointsTeamA,
                                @NotNull(message = "Los puntos del equipo B no pueden ser nulos")
                                Integer pointsTeamB,
                                @NotNull(message = "El deporte no puede ser nulo")
                                Sport sport) {

}
