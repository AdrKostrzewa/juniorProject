package pl.juniorProject.juniorProject;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.juniorProject.juniorProject.converter.BookConverter;
import pl.juniorProject.juniorProject.dto.BookResponseDTO;
import pl.juniorProject.juniorProject.exception.BookNotFoundException;
import pl.juniorProject.juniorProject.exception.InvalidDataException;
import pl.juniorProject.juniorProject.model.Book;

import java.util.List;


@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @GetMapping
    public List<BookResponseDTO> getALlBooks() {
        return bookConverter.convertToBookDTO(bookService.findAll());
    }

    @PostMapping
    public BookResponseDTO addBook(@RequestBody Book book) throws InvalidDataException {
//        Book b = Book.builder().isbn("isbn").title("title").build();
        return bookConverter.convertToBookDTO(bookService.addBook(book));
    }

    @GetMapping("/{id}")
    public BookResponseDTO findById (@PathVariable Long id) throws  BookNotFoundException{
        return bookConverter.convertToBookDTO(bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }

    @DeleteMapping
    public BookResponseDTO removeBook (@RequestParam Long id) throws BookNotFoundException {
        return bookConverter.convertToBookDTO(bookService.removeBook(id));

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDTO updateBook (@RequestParam Long id, @RequestBody Book book) throws BookNotFoundException{
        return bookConverter.convertToBookDTO(bookService.updateBook(id,  book));

    }





}

