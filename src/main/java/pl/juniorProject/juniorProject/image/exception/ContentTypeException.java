package pl.juniorProject.juniorProject.image.exception;

public class ContentTypeException extends Exception {
    public ContentTypeException(){
        super( ("File must be a Image"));
    }
}
