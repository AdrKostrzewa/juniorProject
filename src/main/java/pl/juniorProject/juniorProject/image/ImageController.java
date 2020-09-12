package pl.juniorProject.juniorProject.image;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.dto.ImageResponse;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.exception.ImageNotFoundException;
import pl.juniorProject.juniorProject.image.exception.ContentTypeException;
import pl.juniorProject.juniorProject.image.mapper.ImageMapper;
import pl.juniorProject.juniorProject.model.Image;

import java.util.List;

@RestController
@Api
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @Autowired
    public ImageController( ImageMapper imageMapper, ImageService imageService) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;

    }

    @PostMapping(value = "/{bookId}")
    public ImageResponse addImage(@RequestBody MultipartFile file, @PathVariable Long bookId) throws CloudinaryException, ContentTypeException, BookNotFoundException {
              return this.imageMapper.toImageResponse(this.imageService.addImage(bookId, file));}

    @GetMapping(value = "/{bookId}")
    public List<ImageResponse> findImages(@PathVariable Long bookId) throws BookNotFoundException {
              return this.imageMapper.toImageResponse((this.imageService.findAll(bookId)));
    }


    @DeleteMapping(value = "/{imageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long imageId) throws ImageNotFoundException, CloudinaryException {
        this.imageService.deleteImage(imageId);
    }

    @DeleteMapping(value = "/book/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImageByBookId(@PathVariable Long bookId) throws CloudinaryException, BookNotFoundException {
        this.imageService.deleteImagesByBookId(bookId);
    }
}
