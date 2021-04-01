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
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[this.capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */

    @Override
    public void enqueue(T x) {
        if (x == null) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        /* add the element at the last available spot */
        rb[last] = x;
        fillCount += 1;

        /* if the enqueue fills the queue capacity, reset the pointers*/
        if (last == capacity - 1) {
            last = 0;
            return;
        }

        last += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        /* peek into first element and update fill count*/
        T firstElement = rb[first];
        rb[first] = null;
        fillCount -= 1;

        if (first == capacity - 1) {
            first = 0;
        } else {
            first += 1;
        }

        return firstElement;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    private class ArrayRingIterator implements Iterator<T> {
        private int ringIterator;

        ArrayRingIterator() {
            ringIterator = 0;
        }

        @Override
        public boolean hasNext() {
            return ringIterator != last;
        }

        @Override
        public T next() {
            T nextElement = rb[ringIterator];
            ringIterator += 1;
            return nextElement;
        }
    }
}
