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
       Book b1 = new Book("Book 1", 300, 1999);
        Book b2 = new Book("Book 2", 450, 2005);
        Book b3 = new Book("Book 3", 400, 2018);
        Book b4 = new Book("Book 3", 400, 2018); // идентичная книга
        Book b5 = new Book("Book 5", 350, 2022);
        Book b6 = new Book("Book 6", 250, 2010);
        Book b7 = new Book("Book 7", 150, 2001);
        Book b8 = new Book("Book 8", 500, 2003);
        Book b9 = new Book("Book 9", 600, 2020);

        List<Student> students = List.of(
                new Student("Alice", List.of(b1, b2, b3, b4, b5)),
                new Student("Bob", List.of(b3, b5, b6, b7, b8)),
                new Student("Marko", List.of(b2, b5, b6, b7, b9))
        );

        Optional<Integer> optionalYear = students.stream()
                // 1. Выводим каждого студента
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst();
                optionalYear.ifPresentOrElse(
                year -> System.out.println("Year of the found book: " + year),
                () -> System.out.println("No book found that matches the criteria")
        );
    }
}
