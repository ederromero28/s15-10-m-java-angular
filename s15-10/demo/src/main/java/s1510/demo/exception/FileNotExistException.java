package s1510.demo.exception;

public class FileNotExistException extends RuntimeException{

    public FileNotExistException(String name){
        super(name);
    }
}
