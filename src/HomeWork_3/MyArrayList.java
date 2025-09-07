package HomeWork_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
     public void add(Object value) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = value;
    }
     public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Удаляем ссылку на последний элемент
    }
    public void addAll(MyArrayList other) {
        for (int i = 0; i < other.size; i++) {
            add(other.get(i));
        }
    }
  private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}
