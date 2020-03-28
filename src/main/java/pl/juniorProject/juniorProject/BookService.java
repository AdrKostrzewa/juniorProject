package pl.juniorProject.juniorProject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.juniorProject.juniorProject.model.Book;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook (Long id, Book book) throws IllegalArgumentException{
        Book book1;
        try {
            book1 = bookRepository.getOne(id);
        }catch (EntityNotFoundException e) {
        throw new IllegalArgumentException("That id doesn't exist");
        }
        book1.setTitle(book.getTitle());
        book1.setIsbn(book.getIsbn());
       return  bookRepository.save(book1);
    }




}
