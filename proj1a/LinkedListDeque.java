public class LinkedListDeque<T> {

    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node i, T n, Node j) {
            prev = i;
            item = n;
            next = j;
        }

        public Node(T n) {
            prev = null;
            item = n;
            next = null;
        }
    }

    /* The first item (if it exists) is at sentinel.next.item */
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        Node first = new Node(sentinel, x, sentinel);
        sentinel.prev = first;
        sentinel.next = first;
        size = 1;
    }

    public void addFirst(T item) {
        Node first = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }


    public void addLast(T item) {
        Node last = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node temp = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.item);
            System.out.println(' ');
            temp = temp.next;
        }
        System.out.println("\n");
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinel.next;
        size -= 1;
        sentinel.next = temp.next;
        sentinel.next.prev = sentinel;
        return temp.item;
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node temp = sentinel.prev;
        size -= 1;
        sentinel.prev = temp.prev;
        sentinel.prev.next = sentinel;
        return temp.item;
    }


    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int c = 0;
        Node temp = sentinel;
        while (c <= index) {
            temp = temp.next;
            c += 1;
        }
        return temp.item;
    }

    private T rget(Node l, int c) {
        if (c == 0) {
            return l.item;
        }
        return rget(l.next, c - 1);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return rget(sentinel.next, index);

    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

}
