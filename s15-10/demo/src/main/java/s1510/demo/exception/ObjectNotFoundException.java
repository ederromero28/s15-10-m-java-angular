package s1510.demo.exception;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
