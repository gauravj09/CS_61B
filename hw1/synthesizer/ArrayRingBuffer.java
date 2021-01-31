// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable<T> {
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
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
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
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
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
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        /* peek into first element and update fill count*/
        T firstElement = peek();
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
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    public void printList() {
        System.out.print("[");

        for (int i = 0; i < capacity(); i++) {
            System.out.print(rb[i]);

            if (i == capacity - 1) {
                break;
            }

            System.out.print(", ");
        }

        System.out.print("]");
    }

    private class ArrayRingIterator implements Iterator<T> {
        private int ringIterator;

        public ArrayRingIterator() {
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

    public static void main(String[] args) {
        ArrayRingBuffer<Integer> sampleArr = new ArrayRingBuffer<>(10);
    }
}
