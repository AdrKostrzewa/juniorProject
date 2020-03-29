package pl.juniorProject.juniorProject.exception;

public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super(String.format("No title or author has been provided."));
    }
}
