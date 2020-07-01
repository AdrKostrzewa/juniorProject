package pl.juniorProject.juniorProject.image.facade;

import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.model.Image;

import java.awt.*;

public interface ImageFacade {

        Image addImage(MultipartFile file) throws  CloudinaryException;
    }


