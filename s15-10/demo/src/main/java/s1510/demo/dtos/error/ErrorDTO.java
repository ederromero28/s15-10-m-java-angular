package s1510.demo.dtos.error;

import java.time.LocalDateTime;

public record ErrorDTO(LocalDateTime timeStamp,
                       String message,
                       String details) {
}
