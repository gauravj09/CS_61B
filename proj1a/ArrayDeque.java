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

    /* Commenting out ArrayDeque constructor for Gradescope testing*/
    //    public ArrayDeque(ArrayDeque other) {
    //        items = (T[])new Object[other.size];
    //
    //        for (int i = 0; i < other.size; i++) {
    //            addLast((T) other.get(i));
    //        }
    //
    //        size = other.size;
    //        frontPtr = (size/2) - 1;
    //        backPtr = (size/2) + 1;
    //    }

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

    private void addElement(int addPtr, T x) {
        items[addPtr] = x;
        size += 1;
    }

    public void addFirst(T x) {
        /*resize the array if it is full*/
        if (size == items.length) {
            resize(size * 2);
        }

        /*add element to the front*/
        addElement(frontPtr, x);

        /*move back to the end of the array if it front points to 0*/
        if (frontPtr == 0) {
            frontPtr = items.length - 1;
            return;
        }

        frontPtr -= 1;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }

        /*add element to the back*/
        addElement(backPtr, x);

        /*if backPtr reaches the last Index of the Array */
        if (backPtr == items.length - 1) {
            backPtr = 0;
            return;
        }

        backPtr += 1;
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {

        //garbage input
        if (i >= size || i < 0) {
            return null;
        }

        int circularIndex = frontPtr + 1;
        if (circularIndex + i >= size) {
            return items[(circularIndex + i) % items.length];
        }

        return items[circularIndex + i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private T removeElement(int removePtr) {
        T temp = items[removePtr];
        items[removePtr] = null;
        size -= 1;
        return temp;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (frontPtr == items.length - 1) {
            frontPtr = 0;
        } else {
            frontPtr += 1;
        }

        return removeElement(frontPtr);
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        //realign backptr if it reaches index 0
        if (backPtr == 0) {
            backPtr = items.length - 1;
        } else {
            backPtr -= 1;
        }

        return removeElement(backPtr);
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