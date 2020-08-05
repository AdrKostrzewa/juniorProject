package pl.juniorProject.juniorProject.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.juniorProject.juniorProject.BookService;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.CloudinaryException;
import pl.juniorProject.juniorProject.image.exception.ContentTypeException;
import pl.juniorProject.juniorProject.image.facade.ImageFacade;
import pl.juniorProject.juniorProject.model.Book;
import pl.juniorProject.juniorProject.model.Image;

import java.util.List;
import java.util.Set;

@Service
public class ImageService {
    private final ImageFacade imageFacade;

     private final BookService bookService;
   private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageFacade imageFacade, BookService bookService, ImageRepository imageRepository) {
        this.imageFacade = imageFacade;
        this.bookService = bookService;
        this.imageRepository = imageRepository;
    }

//    public void addBook(MultipartFile file) {
//        imageFacade.addImage(file);
//    }

    @Transactional
    public Image addImage(Long bookId, MultipartFile file) throws CloudinaryException, ContentTypeException, BookNotFoundException {
        if (!isImageType(file.getContentType())) {
            throw new ContentTypeException();
        }

        Book book = bookService.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        Image image = imageFacade.addImage(file);
        image.setBook(book);
        imageRepository.save(image);
        return image;
    }



    private boolean isImageType(String contentType) {
                return contentType.contains("image/");
            }

    public Set<Image> findAll(Long bookId) throws BookNotFoundException {
        Book book = bookService.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        return book.getImages();
    }
}
