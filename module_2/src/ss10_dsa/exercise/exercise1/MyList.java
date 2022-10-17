package ss10_dsa.exercise.exercise1;

import java.util.Arrays;
import java.util.Objects;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity:" + capacity);
        }
    }

    public void add(int index, E element) {
        if (index > elements.length || index < 0) {
            throw new IllegalArgumentException("index:" + index);
        } else if (elements.length == size) {
            this.ensureCapacity(elements.length / 2);

        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            size++;
            System.arraycopy(elements, index, elements, index + 1, size - 1 - index);
            elements[index] = element;
        }
    }


    public E remove(int index) {
        if (index > elements.length || index < 0) {
            throw new IllegalArgumentException("Error index:" + index);
        }
        E temp = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        elements[size - 1] = 0;
        size--;
        return temp;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(E o) {
        return this.indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return index;
    }

    public boolean add(E e) {
        if (elements.length == size) {
            this.ensureCapacity(elements.length / 2);
        }
        elements[size] = e;
        size++;
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyList<?> myList = (MyList<?>) o;
//        return size == myList.size &&
//                Arrays.equals(elements, myList.elements);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(size);
//        result = 31 * result + Arrays.hashCode(elements);
//        return result;
//    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity" + minCapacity);
        }
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = this.size;
        return v;
    }
}
