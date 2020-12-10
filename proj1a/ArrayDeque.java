/** Array based list.
 *  @author Josh Hug
 */

public class ArrayDeque<T> {
    /** Creates an empty list. */
    private T[] items;
    private int size;
    private int frontPtr;
    private int backPtr;
    private int RESIZE_HELPER = 4;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        frontPtr = 3;
        backPtr = 4;
    }

    public ArrayDeque(ArrayDeque other) {
        items = (T[])new Object[other.size];

        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }

        size = other.size;
        frontPtr = (size/2) - 1;
        backPtr = (size/2) + 1;
    }

    /** Resize size to size * 2*/
    private void resize(int capacity) {
        T[] tempArr = (T[])new Object[capacity];
        int ptr = frontPtr + 1;
        int ptrToResize = RESIZE_HELPER;
        //System.arraycopy(items, frontPtr, tempArr, RESIZE_HELPER, size);

        for (int i = 0; i < size; i++) {
            tempArr[ptrToResize] = items[ptr];
            ptr++;
            ptrToResize++;

            if (ptr == items.length) {
                ptr = 0;
            }
        }

        items = tempArr;
        frontPtr = RESIZE_HELPER - 1;
        backPtr = size + RESIZE_HELPER;
        RESIZE_HELPER *= 2;
    }

    public void addFirst(T x) {
        /*resize the array if it is full*/
        if (size == items.length) {
            resize(size * 2);
        }

        if (frontPtr == 0) {
            updatePtrAdder(frontPtr, items.length - 1, x);
            return;
        }

        items[frontPtr] = x;
        size += 1;
        frontPtr -= 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        if (backPtr == items.length - 1) {
            updatePtrAdder(backPtr, 0, x);
            return;
        }

        items[backPtr] = x;
        size += 1;
        backPtr += 1;
    }

    private void updatePtrAdder(int currentIndexLocation, int updatedIndexLocation, T x) {
        items[currentIndexLocation] = x;
        size += 1;
        updatePtr(currentIndexLocation, updatedIndexLocation);
    }

    private void updatePtr(int currentIndexLocation, int updatedIndexLocation) {
        if (currentIndexLocation == frontPtr) {
            frontPtr = updatedIndexLocation;
            return;
        }

        if (currentIndexLocation == backPtr) {
            backPtr = updatedIndexLocation;
        }
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {

        //garbage input
        if (i >= size || i < 0) {
            return null;
        }

        int circularIndex = frontPtr + 1 + i;

        if (circularIndex >= size) {
            return items[circularIndex - size];
        }
        return items[circularIndex];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (frontPtr == items.length - 1) {
            updatePtr(frontPtr, 0);
        }

        T temp = items[frontPtr + 1];
        items[frontPtr + 1] = null;
        size -= 1;
        frontPtr += 1;
        return temp;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        //realign backptr if it reaches index 0
        if (backPtr == 0) {
            updatePtr(backPtr, items.length);
        }

        T temp = items[backPtr - 1];
        items[backPtr - 1] = null;
        size -= 1;
        backPtr -= 1;
        return temp;
    }

    public void printDeque() {
        int iterate = 0;
        int ptr = frontPtr + 1;

        while (iterate < size) {
            if (ptr == items.length) {
                ptr = 0;
            }

            System.out.print(items[ptr] + " ");
            ptr++;
            iterate += 1;
        }
    }


}