package s1510.demo.dtos.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile(value = {"dev", "prod", "test"})


public record MatchRequestDTO(
        @NotNull(message = "La fecha de inicio no puede ser nula")
        LocalDateTime startAt,
        @NotNull(message = "La fecha de fin no puede ser nula")
        @FutureOrPresent(message = "La fecha de fin debe ser en el presente o futuro")
        LocalDateTime endAt,
        @NotNull(message = "Los puntos del equipo A no pueden ser nulos")
        @Min(value = 0, message = "Los puntos del equipo A no pueden ser negativos")
        Integer pointsTeamA,
        @NotNull(message = "Los puntos del equipo B no pueden ser nulos")
        @Min(value = 0, message = "Los puntos del equipo B no pueden ser negativos")
        Integer pointsTeamB,
        @NotNull(message = "El ID del deporte no puede ser nulo")
        @Positive(message = "El ID del deporte debe ser un número positivo")
        Long sportId) {

}
