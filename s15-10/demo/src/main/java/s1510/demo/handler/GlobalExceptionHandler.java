package s1510.demo.handler;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import s1510.demo.dtos.error.ErrorDTO;
import s1510.demo.exception.BadRequestException;
import s1510.demo.exception.FileNotExistException;
import s1510.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
@Profile(value = {"dev", "prod", "test"})
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), "An unespected error ocurred", request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FileNotExistException.class)
    public ResponseEntity<ErrorDTO> handleFileNotExistException(FileNotExistException ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(LocalDateTime.now(), "File not exist exception", request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_ACCEPTABLE);
    }
}
