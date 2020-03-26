package pl.juniorProject.juniorProject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.juniorProject.juniorProject.model.Book;

import java.util.List;
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
}
