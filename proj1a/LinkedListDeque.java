public class LinkedListDeque<T> {
    public class GenericNode {
        public GenericNode next;
        public GenericNode prev;
        public T val;

        public GenericNode(GenericNode p, T i, GenericNode n) {
            prev = p;
            val = i;
            next = n;
        }
    }

    private GenericNode sentinel;
    private int size = 0;

    public LinkedListDeque() {
        sentinel = new GenericNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        GenericNode first = new GenericNode(sentinel, item, sentinel.next);
        sentinel.next = first;
        first.next.prev = first;
        size++;
    }

    public void addLast(T item) {
        GenericNode last = new GenericNode(sentinel.prev, item, sentinel);
        sentinel.prev = last;
        last.prev.next = last;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T first = sentinel.next.val;
        GenericNode ptr = sentinel.next;
        sentinel.next = ptr.next;
        ptr.next.prev = sentinel;
        ptr.prev = null;
        ptr.next = null;
        size--;

        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T last = sentinel.prev.val;
        GenericNode ptr = sentinel.prev;
        sentinel.prev = ptr.prev;
        ptr.prev.next = sentinel;
        ptr.prev = null;
        ptr.next = null;
        size--;

        return last;
    }

    public T get(int index) {
        if (size() <= index) {
            return null;
        }

        GenericNode ptr = sentinel.next;
        T item = null;
        int counter = 0;

        while (counter < index) {
            ptr = ptr.next;

            if (ptr.next == null) {
                return null;
            }

            counter++;
        }

        return ptr.val;
    }

    public T getRecursive(int index) {
        if (size() < index) {
            return null;
        }

        return recursiveHelper(0, index, sentinel.next);
    }

    public T recursiveHelper(int counter, int index, GenericNode ptr) {
        if (counter >= index) {
            return ptr.val;
        }

        return recursiveHelper(counter + 1, index, ptr.next);
    }

    public void printDeque() {
        int iterate = 0;
        GenericNode ptr = sentinel;

        while (iterate < size()) {
            ptr = ptr.next;
            System.out.print(ptr.val + " ");
            iterate++;
        }
    }
}
