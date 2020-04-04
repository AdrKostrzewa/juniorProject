package pl.juniorProject.juniorProject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.InvalidDataException;
import pl.juniorProject.juniorProject.model.Book;

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

    public Book
    removeBook(Long id) throws  BookNotFoundException {

//        Optional<Book> foundBook = findById(id);
//         if (foundBook.isPresent()) {
//              try{  bookRepository.deleteById(id);}
//              catch ( Exception e){
//                 throw new ServerException(String.format("Something went wrong during removing a book by id: %d. Exception message: %s",id, e.getMessage() ));
//              }
//
//        } else {
//            throw new BookNotFoundException(id);
//        }
//
//return foundBook.get();

        return findById(id).map(
                book -> {bookRepository.delete(book);
                return book;}
        ).orElseThrow(() -> new BookNotFoundException(id));

    }

    public Book updateBook (Long id, Book book) throws BookNotFoundException{
//        Book book1;
//        try {
//            book1 = bookRepository.getOne(id);
//        }catch (EntityNotFoundException e) {
//        throw new BookNotFoundException(id);
//        }
//        book1.setTitle(bookDataDTO.getTitle());
//        book1.setIsbn(bookDataDTO.getIsbn());
//       return  bookRepository.save(book1);

        return findById(id).map(book1 -> {
            book1.setIsbn(book.getIsbn());
            book1.setTitle(book.getTitle());
            return bookRepository.save(book1);
        }).orElseThrow(() ->new  BookNotFoundException(id));

    }




}
