package pl.juniorProject.juniorProject.exception;

import java.util.function.Supplier;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(Long id) {
        super(String.format("Book %d doesn't found ", id));
    }
}
