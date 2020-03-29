package pl.juniorProject.juniorProject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler({BookNotFoundException.class})
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public String bookNotFoundException (BookNotFoundException ex){
        return ex.getMessage();

    }
}
