package s1510.demo.exception;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
