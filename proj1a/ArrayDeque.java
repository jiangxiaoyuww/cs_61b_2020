public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int start;
    private int end;


    private void resize(int c) {
        /* double the size when it uses more than 2/3 */
        T[] temp = (T []) new Object[c];
        if (start + 1 + size < capacity) {
            System.arraycopy(items, start + 1, temp, 0, size);
        } else {
            System.arraycopy(items, start + 1, temp, 0, capacity - start - 1);
            System.arraycopy(items, 0, temp, capacity - start - 1, size - capacity + start + 1);
        }
        capacity = c;
        start = c - 1;
        end = size;
        items = temp;
    }

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        capacity = 8;
        start = capacity / 2 - 1;
        end = capacity / 2;
    }

    public void addFirst(T item) {
        items[start] = item;
        size += 1;
        start = (start - 1 + capacity) % capacity;
        if (size >= capacity * 2 / 3) {
            resize(capacity * 2);
        }
    }

    public void addLast(T item) {
        items[end] = item;
        size += 1;
        end = (end + 1 + capacity) % capacity;
        if (size >= capacity * 2 / 3) {
            resize(capacity * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[(start + 1 + i + capacity) % capacity]);
            System.out.println(' ');
        }
        System.out.println("\n");
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        start = (start + 1) % capacity;
        T temp = items[start];
        if (size <= capacity / 4 && capacity > 8) {
            resize(capacity / 2);
        }
        return temp;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        end = (end - 1 + capacity) % capacity;
        T temp = items[end];
        if (size <= capacity / 4 && capacity > 8) {
            resize(capacity / 2);
        }
        return temp;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(start + 1 + index + capacity) % capacity];
    }


}
