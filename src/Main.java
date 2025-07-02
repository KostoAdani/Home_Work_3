import HomeWork_3.Book;
import HomeWork_3.MyArrayList;
import HomeWork_3.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Book 1 ", 300, 1999);
        Book b2 = new Book("Book 2 ", 450, 2005);
        Book b3 = new Book("Book 3 ", 400, 2018); //создал две идентичные книги для проверки на уникальность
        Book b4 = new Book("Book 3 ", 400, 2018); // вот этот скопирован полностью
        Book b5 = new Book("Book 5 ", 350, 2022);
        Book b6 = new Book("Book 6 ", 250, 2010);
        Book b7 = new Book("Book 7 ", 150, 2001);
        Book b8 = new Book("Book 8 ", 500, 2003);
        Book b9 = new Book("Book 9 ", 600, 2020);

        // Создаем студентов и им даем книги
        List<Student> students = List.of(
                new Student("Alice",List.of(b1,b2,b3,b4,b5)),
                new Student("Bob",List.of(b3,b5,b6,b7,b8)),
                new Student("Marko",List.of(b2,b5,b6,b7,b9))
        );
        students.stream()
                .forEach(student -> System.out.println(student));
        students.stream() //для наглядности преобразовал метод ту стринг с книгами для каждого студента
                .map(student -> student.getBooks())
                .forEach(books -> System.out.println(books));
        List<Book> allBooksSorted = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .collect(Collectors.toList());

        System.out.println("Все книги, отсортированные по страницам:");
        allBooksSorted.forEach(System.out::println);
        List<Book> uniqueBooks = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Уникальные книги:");
        uniqueBooks.forEach(System.out::println);
        List<Book> booksAfter2000 = uniqueBooks.stream()
                .filter(book -> book.getYear() > 2000)
                .collect(Collectors.toList());

        System.out.println("Книги, выпущенные после 2000 года:");
        booksAfter2000.forEach(System.out::println);
        List<Book> limitedBooks = booksAfter2000.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Первые 3 книги из этого списка:");
        limitedBooks.forEach(System.out::println);
        List<Integer> years = limitedBooks.stream()
                .map(Book::getYear)
                .collect(Collectors.toList());
        System.out.println("Года выпуска первых 3 книг:");
        years.forEach(System.out::println);
        Optional<Book> optBook = students.stream()
                .flatMap(student -> student.getBooks().stream())
                .filter(book -> book.getYear() > 2010)
                .findFirst();
        int year = optBook.map(Book::getYear).orElse(-1);
        if (year != -1) {
            System.out.println("Год выпуска найденной книги: " + year);
        } else {
            System.out.println("Такая книга не найдена");
        }
    }
}