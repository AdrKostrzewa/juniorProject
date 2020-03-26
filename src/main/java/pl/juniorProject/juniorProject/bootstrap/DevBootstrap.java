package pl.juniorProject.juniorProject.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.juniorProject.juniorProject.model.Book;
import pl.juniorProject.juniorProject.BookService;

@Component
@RequiredArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final BookService bookService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
    }

    private void initData() {
        this.bookService.addBook(Book.builder().isbn("isbn1").title("title1").build());
        this.bookService.addBook(Book.builder().isbn("isbn2").title("title2").build());
        this.bookService.addBook(Book.builder().isbn("isbn3").title("title3").build());
    }
}