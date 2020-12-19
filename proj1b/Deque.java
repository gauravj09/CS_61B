public interface Deque<Item> {
    public void addFirst(Item x);
    public void addLast(Item x);
    public Item removeFirst();
    public Item removeLast();
    public boolean isEmpty();
    public Item get(int i);
    public int size();
    public void printDeque();
}
