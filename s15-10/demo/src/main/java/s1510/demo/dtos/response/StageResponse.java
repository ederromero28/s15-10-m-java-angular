package s1510.demo.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Profile;
import s1510.demo.enums.StageType;
import s1510.demo.model.Stage;

@Profile(value = {"dev", "prod", "test"})

public record StageResponse(
        Long id,
        @NotNull StageType stageType,
        @NotBlank String winner) {
    public StageResponse(Stage stage) {
        this(
                stage.getId(),
                stage.getStageType(),
                stage.getWinner()
        );
    }

    public StageResponse {

    }
}
