package s1510.demo.dtos.error;

import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile(value = {"dev", "prod", "test"})

public record ErrorDTO(LocalDateTime timeStamp,
                       String message,
                       String details) {
}
