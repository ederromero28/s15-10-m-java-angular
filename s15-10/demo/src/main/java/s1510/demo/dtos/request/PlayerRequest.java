package s1510.demo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})

public record PlayerRequest(@NotBlank String name,
                            @NotBlank String email,
                            @NotBlank String contactEmail,
                            @NotBlank String password,
                            @NotBlank String phone
			    @NotBlank String country
			    ) {
}
