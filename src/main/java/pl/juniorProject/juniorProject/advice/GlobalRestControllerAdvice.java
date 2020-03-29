package pl.juniorProject.juniorProject.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.juniorProject.juniorProject.exception.ServerException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler({ServerException.class})
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverException (ServerException ex){
        return (ex.getMessage());
    }
}
