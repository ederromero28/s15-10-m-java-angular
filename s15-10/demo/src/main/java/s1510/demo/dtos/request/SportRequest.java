package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SportRequest(@NotBlank String name, @NotNull int teamSize, @NotNull int rounds) {}
