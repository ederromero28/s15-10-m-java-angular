package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CompetitionRequest(

        @NotBlank
        String name,
        @NotNull
        int size
) {}