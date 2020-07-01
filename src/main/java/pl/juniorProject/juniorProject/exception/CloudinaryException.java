package pl.juniorProject.juniorProject.exception;

public class CloudinaryException extends Exception {

    public CloudinaryException (String message){
        super(String.format("Something went wrong during upload image, details: %s", message));
    }

}
