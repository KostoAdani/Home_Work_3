package HomeWork_3;

import javax.xml.namespace.QName;
import java.util.List;

public class Student {
    private String name;
    private final List<Book> books;

    public Student(String name,List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Student: " + name + "Books: " + books;
    }
}
