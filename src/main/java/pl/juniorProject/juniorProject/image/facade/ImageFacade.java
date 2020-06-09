package pl.juniorProject.juniorProject.image.facade;

import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

public interface ImageFacade {

        Image addImage(MultipartFile file);
    }


