package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Profile;
import s1510.demo.enums.StageType;

@Profile(value = {"dev", "prod", "test"})

public record StageRequest(
        Long id,
//        @NotNull
        StageType stageType,
//        @NotBlank
        String winner) {
}
