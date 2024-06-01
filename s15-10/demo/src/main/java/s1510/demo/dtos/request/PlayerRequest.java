package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record PlayerRequest(@NotBlank String name,
                            @NotBlank String email,
                            @NotBlank String contactEmail,
                            @NotBlank String password,
                            @NotBlank String phone) {
}
