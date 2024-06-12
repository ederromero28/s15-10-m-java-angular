package s1510.demo.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})

public record TeamRequest(@Email @NotBlank String email,
                          @NotBlank String password,
                          @NotBlank String name) {
}
