package pl.juniorProject.juniorProject.image;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.dto.ImageResponseDTO;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.image.ImageConverter;
import pl.juniorProject.juniorProject.image.ImageService;

@RestController
@Api
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;
    private final ImageConverter imageConverter;

    @Autowired
    public ImageController(ImageService imageService, ImageConverter imageConverter) {
        this.imageService = imageService;
        this.imageConverter = imageConverter;
    }

    @PostMapping
    public ImageResponseDTO addBook(@RequestBody MultipartFile file) throws CloudinaryException {
        return this.imageConverter.convertToImageDTO(this.imageService.addBook(file));
    }
}
