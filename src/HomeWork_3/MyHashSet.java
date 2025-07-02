package HomeWork_3;
import java.util.ArrayList;
import java.util.List;



public class MyHashSet<T> {
    private final List<T> elements;


    public MyHashSet(){
        elements = new ArrayList<>();
    }
    public void insert(T element) {
        if (!elements.contains(element)) {
            elements.add(element);

        }
    }
    public boolean contains(T element){
        return elements.contains(element);
    }
    public boolean remove(T element){
        return elements.remove(element);
    }
}

