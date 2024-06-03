package s1510.demo.exception;

import org.springframework.context.annotation.Profile;

@Profile(value = {"dev", "prod", "test"})
public class FileNotExistException extends RuntimeException {

    public FileNotExistException(String name) {
        super(name);
    }
}
