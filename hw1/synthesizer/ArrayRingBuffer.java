package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;



    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        first = 0;
        last = 0;
        this.fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    public void enqueue(T x) {
        if (this.fillCount == this.capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[(last + 1) % capacity] = x;
        last = (last + 1 + this.capacity) % capacity;
        this.fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        first = (first + 1 + this.capacity) % capacity;
        this.fillCount -= 1;
        return rb[first];
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[(first + 1 + this.capacity) % capacity];
    }



    private class SIterator implements Iterator<T> {
        private int pOs;

        SIterator() {
            pOs = 0;
        }

        public boolean hasNext() {
            return pOs < fillCount;
        }

        public T next() {
            T returnItem = rb[(pOs + first + 1 + capacity) % capacity];
            pOs += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new SIterator();
    }
}
