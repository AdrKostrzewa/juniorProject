package pl.juniorProject.juniorProject.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.image.exception.ContentTypeException;
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

    public Image addImage(MultipartFile file) throws ContentTypeException, CloudinaryException {
        if (!isImageType(file.getContentType())){
            throw new ContentTypeException();
        }
        return imageFacade.addImage(file);
    }

    private boolean isImageType(String contentType) {
                return contentType.contains("image/");
            }
}
