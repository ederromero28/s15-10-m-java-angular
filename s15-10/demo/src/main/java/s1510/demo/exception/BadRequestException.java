package s1510.demo.exception;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
