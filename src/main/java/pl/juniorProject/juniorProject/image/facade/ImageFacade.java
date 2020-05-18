package pl.juniorProject.juniorProject.image.facade;

import org.springframework.web.multipart.MultipartFile;

public interface ImageFacade {

        void addImage(MultipartFile file);
    }


