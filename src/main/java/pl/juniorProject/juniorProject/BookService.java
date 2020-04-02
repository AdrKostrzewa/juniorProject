package pl.juniorProject.juniorProject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.juniorProject.juniorProject.dto.BookDataDTO;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.InvalidDataException;
import pl.juniorProject.juniorProject.exception.ServerException;
import pl.juniorProject.juniorProject.model.Book;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) throws InvalidDataException {
        if (book.getIsbn().isEmpty() || book.getTitle().isEmpty()){
            throw new InvalidDataException();
        }else

        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book removeBook(Long id) throws ServerException, BookNotFoundException {

        Optional<Book> foundBook = findById(id);
         if (foundBook.isPresent()) {
              try{  bookRepository.deleteById(id);}
              catch ( Exception e){
                 throw new ServerException(String.format("Something went wrong during removing a book by id: %d. Exception message: %s",id, e.getMessage() ));
              }

        } else {
            throw new BookNotFoundException(id);
        }

return foundBook.get();
    }

    public Book updateBook (Long id, BookDataDTO bookDataDTO) throws BookNotFoundException{
        Book book1;
        try {
            book1 = bookRepository.getOne(id);
        }catch (EntityNotFoundException e) {
        throw new BookNotFoundException(id);
        }
        book1.setTitle(bookDataDTO.getTitle());
        book1.setIsbn(bookDataDTO.getIsbn());
       return  bookRepository.save(book1);


    }




}
