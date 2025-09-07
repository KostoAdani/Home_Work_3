package HomeWork_3;
import java.util.ArrayList;
import java.util.List;


public class MyHashSet<T> {
    private final List<T> elements;


    public MyHashSet() {
        elements = new ArrayList<>();
    }

    public void insert(T element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }
public boolean contains(T element) {
        if (element == null) {
            for (T e : elements) {
                if (e == null) {
                    return true;
                }
            }
            return false;
        } else {
            for (T e : elements) {
                if (element.equals(e)) {
                    return true;
                         }
            }
            return false;
        }
    }

    public boolean remove(T element) {
        return elements.remove(element);
    }
}
