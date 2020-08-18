package pl.juniorProject.juniorProject.exception;

public class ImageNotFoundException  extends Exception{

    public ImageNotFoundException (Long id){
        super(String.format("Image %d doesn't exist!", id));
    }
}
