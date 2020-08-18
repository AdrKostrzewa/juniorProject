package pl.juniorProject.juniorProject.image.facade;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.model.Image;

import java.awt.*;
import java.io.IOException;
import java.nio.file.ClosedDirectoryStreamException;
import java.util.Map;


@Service
public class CloudinaryFacade implements ImageFacade {


    private final Cloudinary cloudinary;
    private final static String URL = "secure_url";
    private final static String SAVED_NAME = "public_id";

        @Autowired
        public CloudinaryFacade(Cloudinary cloudinary) {
            this.cloudinary = cloudinary;
        }

    @Override
    public Image addImage(MultipartFile file) throws CloudinaryException {
        try {
            Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return Image.builder()
                    .originName(file.getOriginalFilename())
                    .size(file.getSize())
                    .savedName(upload.get(SAVED_NAME).toString())
                    .url(upload.get(URL).toString())
                    .build();
        } catch (IOException e) {
            throw new CloudinaryException(e.getMessage());
        }

    }


    @Override
    public void deleteImage(Image image) throws CloudinaryException {
        try {
            cloudinary.uploader().destroy(image.getSavedName(), ObjectUtils.emptyMap());
        } catch (IOException e) {
            throw new CloudinaryException(e.getMessage());
        }
    }
}
