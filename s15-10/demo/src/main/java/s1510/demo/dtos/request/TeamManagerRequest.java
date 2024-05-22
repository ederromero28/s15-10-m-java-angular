package s1510.demo.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record TeamManagerRequest(@Email @NotBlank String email,
                                 @NotBlank String password,
                                 @NotBlank String name) {
}
