package s1510.demo.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import s1510.demo.enums.StageType;
import s1510.demo.model.Stage;

public record StageResponse(Long id, @NotNull StageType stageType, @NotBlank String winner) {
    public StageResponse(Stage stage) {
        this(stage.getId(), stage.getStageType(), stage.getWinner());
    }
}
