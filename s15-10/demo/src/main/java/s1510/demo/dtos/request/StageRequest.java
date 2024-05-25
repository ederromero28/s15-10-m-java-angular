package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import s1510.demo.enums.StageType;

public record StageRequest(Long id, @NotNull StageType stageType, @NotBlank String winner) {
}
