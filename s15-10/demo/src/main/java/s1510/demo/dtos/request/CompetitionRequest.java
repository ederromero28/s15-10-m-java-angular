package s1510.demo.dtos.request;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.context.annotation.Profile;
import s1510.demo.model.Award;
import s1510.demo.model.Stage;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Profile(value = {"dev", "prod", "test"})

public record CompetitionRequest(

        @NotBlank(message= "El nombre no puede estar en blanco")
        String name,
        @NotNull(message= "La cantidad de etapas es requerida")
        int stageCount,
        @NotNull(message= "La fecha de inicio para competiciones es requerida ")
        @FutureOrPresent(message = "La fecha de inicio de competiciones debe ser en el presente o futuro")
        LocalDate dateStart,
        @NotNull(message= "La fecha de finalización para competiciones es requerida ")
        @FutureOrPresent(message = "La fecha de finalización de competiciones debe ser en el presente o futuro")
        LocalDate dateEnd,
        @NotNull(message = "La competición requiere una lista de premios")
        Set<Award> awards,
        @NotNull(message = "La competición requiere una lista de etapas")
        List<Stage> stages
) {
}