

import school.sorokin.javacore.exception.custom_exception.BookNotFoundException;
import school.sorokin.javacore.exception.custom_exception.NoAvailableCopiesException;
import school.sorokin.javacore.exception.Library;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public static void main(String[] args) {
    Library library = new Library(new HashSet<>());
    boolean flag = true;
    try (Scanner scanner = new Scanner(System.in)) {
        while (flag) {
            try {
                print();
                int val = scanner.nextInt();
                scanner.nextLine();
                switch (val) {
                    case 1: {
                        System.out.println(library.getAllBooks());
                        break;
                    }
                    case 2: {
                        System.out.println("Введите название книги");
                        String nameBook = scanner.nextLine();
                        System.out.println("Введите автора книги");
                        String author = scanner.nextLine();
                        System.out.println("Введите количество копий");
                        int availableCopies = scanner.nextInt();
                        scanner.nextLine();
                        library.addBook(nameBook, author, availableCopies);
                        break;
                    }
                    case 3: {
                        System.out.println("Введите название книги, которую хотите получить");
                        String title = scanner.nextLine();
                        library.takeBook(title);
                        break;
                    }
                    case 4: {
                        System.out.println("Введите название книги, которую хотите вернуть");
                        String title = scanner.nextLine();
                        library.returnBook(title);
                        break;
                    }
                    case 5: {
                        flag = false;
                    }
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Введите правильное значение");
            } catch (NoAvailableCopiesException | BookNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public static void print() {
    System.out.println("1 - Вывести список всех книг");
    System.out.println("2 - Добавить объект");
    System.out.println("3 - Выдать объект");
    System.out.println("4 - Вернуть объект");
    System.out.println("5 - Выход");
}
