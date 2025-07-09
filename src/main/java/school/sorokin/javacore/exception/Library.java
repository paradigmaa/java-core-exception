package school.sorokin.javacore.exception;

import school.sorokin.javacore.exception.custom_exception.BookNotFoundException;
import school.sorokin.javacore.exception.custom_exception.NoAvailableCopiesException;

import java.util.*;

public class Library {
    private final Set<Book> catalog;

    public Library(Set<Book> catalog) {
        this.catalog = catalog;
    }

    public void addBook(String title, String author, int availableCopies) {
        if (availableCopies > 0) {
            catalog.add(new Book(title, author, availableCopies));
        } else {
            throw new BookNotFoundException("Введите значение больше нуля");
        }
    }

    public void takeBook(String title) throws NoAvailableCopiesException {
        Optional<Book> opt = catalog.stream()
                .filter(n -> n.getTitle()
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
                .filter(n -> n.getTitle()
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
        if (this.catalog.isEmpty()) {
            System.out.println("Cписок пуст");
        }
        return this.catalog;
    }

}
