package pl.juniorProject.juniorProject.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.image.facade.ImageFacade;
import pl.juniorProject.juniorProject.model.Image;

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

    public Image addBook(MultipartFile file) throws CloudinaryException {
        return imageFacade.addImage(file);
    }
}
