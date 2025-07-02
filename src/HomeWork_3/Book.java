package HomeWork_3;

import java.util.List;

public class Book {
    private final String title;
    private final int pages;
    private final int year;


    public Book(String title,int pages,int year){
        this.title = title;
        this.pages = pages;
        this.year = year;

    }
    public int getPages(){
        return  pages;
    }
    public int getYear(){
        return year;
    }
    @Override
    public String toString() {
        return  title + " (" + year + ", " + pages + " стр.)";
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Book)) return false;
        Book other = (Book) o;
        return title.equals(other.title)&&pages == other.pages && year == other.year;
    }
    @Override
    public int hashCode(){
        return title.hashCode() + pages + year ;
    }
}
