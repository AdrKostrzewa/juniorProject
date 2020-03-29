package pl.juniorProject.juniorProject;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.InvalidDataException;
import pl.juniorProject.juniorProject.exception.ServerException;
import pl.juniorProject.juniorProject.model.Book;

import java.util.List;
import java.util.Optional;


@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getALlBooks() {
        return bookService.findAll();
    }


    @PostMapping
    public Book addBook(@RequestBody Book book) throws InvalidDataException {
//        Book b = Book.builder().isbn("isbn").title("title").build();
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Optional<Book> findById (@PathVariable Long id){
        return bookService.findById(id);
    }

    @DeleteMapping
    public void removeBook (@RequestParam Long id) throws BookNotFoundException, ServerException {
         bookService.removeBook(id);

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBook (@RequestParam Long id, @RequestBody Book book) throws BookNotFoundException{
        return bookService.updateBook(id, book);

    }





}

