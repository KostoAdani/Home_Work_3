package HomeWork_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList <T>{
    private final ArrayList<T> elements;

    public MyArrayList(){
        elements = new ArrayList<>();
    }
    public void add(T element){
        elements.add(element);
    }
    public T get(int index){
        return elements.get(index);
    }
    public void remove(int index){
        elements.remove(index);
    }
    public void addAll(List<T>other){
        elements.addAll(other);
    }
    public List<T> getElements(){
        return elements;
    }
}
