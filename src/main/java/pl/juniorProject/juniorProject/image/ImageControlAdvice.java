package pl.juniorProject.juniorProject.image;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.exception.ImageNotFoundException;
import pl.juniorProject.juniorProject.image.exception.ContentTypeException;

public class ImageControlAdvice {
    @ExceptionHandler({CloudinaryException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cloudinaryException(CloudinaryException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler({ContentTypeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String contentTypeException(ContentTypeException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler({ImageNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String imageNotFoundException(ImageNotFoundException ex) {
        return ex.getMessage();
    }

}
