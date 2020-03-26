package pl.juniorProject.juniorProject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.juniorProject.juniorProject.model.Book;
import pl.juniorProject.juniorProject.BookService;

import java.util.List;



@RestController
@RequiredArgsConstructor
public class BookController {

   private final BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
//        Book b = Book.builder().isbn("isbn").title("title").build();
        return bookService.addBook(book);
    }


    @GetMapping
    public List<Book> getALlBooks() {
        return bookService.findAll();
    }
}
