package pl.juniorProject.juniorProject.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.image.facade.ImageFacade;

import java.awt.*;

@Service
public class ImageService {
    private final ImageFacade imageFacade;

    @Autowired
    public ImageService(ImageFacade imageFacade) {
        this.imageFacade = imageFacade;
    }

//    public void addBook(MultipartFile file) {
//        imageFacade.addImage(file);
//    }

    public Image addBook(MultipartFile file){
        return imageFacade.addImage(file);
    }
}
