public class LinkedListDeque<LochNess> {

    private class Node {
        public Node prev;
        public LochNess item;
        public Node next;

        public Node(Node i, LochNess n, Node j) {
            prev = i;
            item = n;
            next = j;
        }

        public Node(LochNess n) {
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

    public LinkedListDeque(LochNess x) {
        sentinel = new Node(null, null, null);
        Node first = new Node(sentinel, x, sentinel);
        sentinel.prev = first;
        sentinel.next = first;
        size = 1;
    }

    public void addFirst(LochNess item) {
        Node first = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size += 1;
    }


    public void addLast(LochNess item) {
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
        for (int i = 0; i < size; i++){
            System.out.println(temp.item);
            System.out.println(' ');
            temp = temp.next;
        }
        System.out.println("\n");
    }


    public LochNess removeFirst() {
        if (size == 0) {
            return null;
        }
        LochNess item = sentinel.next.item;
        size -= 1;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        return item;
    }


    public LochNess removeLast() {
        if (size == 0) {
            return null;
        }
        LochNess item = sentinel.prev.item;
        size -= 1;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        return item;
    }


    public LochNess get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int c = 0;
        Node temp = sentinel;
        while (c <= index){
            temp = temp.next;
            c += 1;
        }
        return temp.item;
    }

    private LochNess rget(Node l, int c){
        if (c == 0) {
            return l.item;
        }
        return rget(l.next, c-1);
    }

    public LochNess getRecursive(int index){
        if (index >= size || index < 0) {
            return null;
        }
        return rget(sentinel.next, index);

    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for (int i = 0; i < other.size(); i ++){
            addLast((LochNess) other.get(i));
        }
    }

}
