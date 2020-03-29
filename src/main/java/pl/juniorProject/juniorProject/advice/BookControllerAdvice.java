package pl.juniorProject.juniorProject.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.InvalidDataException;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler({BookNotFoundException.class})
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public String bookNotFoundException (BookNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler({InvalidDataException.class})
    @ResponseStatus (HttpStatus.BAD_REQUEST)
    public String invalidDataException (InvalidDataException ex){
        return ex.getMessage();
    }
}
