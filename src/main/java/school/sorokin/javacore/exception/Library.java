package school.sorokin.javacore.exception;

import school.sorokin.javacore.exception.CustomException.BookNotFoundException;
import school.sorokin.javacore.exception.CustomException.NoAvailableCopiesException;

import java.util.*;

public class Library {
    private Set<Book> catalog = new LinkedHashSet<>();

    public void addBook(String title, String author, int availableCopies) {
        catalog.add(new Book(title, author, availableCopies));
    }

    public void takeBook(String title) throws NoAvailableCopiesException {
        Optional<Book> opt = catalog.stream()
                .filter(n -> n.getTittle()
                        .equals(title))
                .findAny();
        if (opt.isPresent()) {
            Book book = opt.get();
            int copies = book.getAvailableCopies();
            if (copies > 0) {
                book.setAvailableCopies(copies - 1);
            } else {
                throw new NoAvailableCopiesException("Этой книги пока нет");
            }
        } else {
            throw new BookNotFoundException("Такой книги не существует");
        }
    }

    public void returnBook(String title) {
        Optional<Book> opt = catalog.stream()
                .filter(n -> n.getTittle()
                        .equals(title))
                .findAny();
        if (opt.isPresent()) {
            Book book = opt.get();
            int copies = book.getAvailableCopies();
            book.setAvailableCopies(copies + 1);
        } else {
            throw new BookNotFoundException("Такой книги нет в библиотеке");
        }
    }

    public Set<Book> getAllBooks() {
        return this.catalog;
    }

    ;
}
