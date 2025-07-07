package school.sorokin.javacore.exception;

import school.sorokin.javacore.exception.CustomException.BookNotFoundException;
import school.sorokin.javacore.exception.CustomException.NoAvailableCopiesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.books();
    }

    public void books() {
        Library library = new Library();
        boolean flag = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                try {
                    print();
                    int val = scanner.nextInt();
                    scanner.nextLine();
                    if (val == 1) {
                        System.out.println(library.getAllBooks());
                    } else if (val == 2) {
                        System.out.println("Введите название книги");
                        String nameBook = scanner.nextLine();
                        System.out.println("Введите автора книги");
                        String author = scanner.nextLine();
                        System.out.println("Введите количество копий");
                        int availableCopies = scanner.nextInt();
                        scanner.nextLine();
                        library.addBook(nameBook, author, availableCopies);
                    } else if (val == 3) {
                        System.out.println("Введите название книги, которую хотите получить");
                        String title = scanner.nextLine();
                        library.takeBook(title);
                    } else if (val == 4) {
                        System.out.println("Введите название книги, которую хотите вернуть");
                        String title = scanner.nextLine();
                        library.returnBook(title);
                    } else if (val == 5) {
                        flag = false;
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Введите правильное значение");
                } catch (NoAvailableCopiesException e) {
                    System.out.println(e.getMessage());
                } catch (BookNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }


    public void print() {
        System.out.println("1 - Вывести список всех книг");
        System.out.println("2 - Добавить объект");
        System.out.println("3 - Выдать объект");
        System.out.println("4 - Вернуть объект");
        System.out.println("5 - Выход");
    }

}
