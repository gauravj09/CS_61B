public class LLD_Test {
    public static void main(String[] args) {
        LinkedListDeque<Integer> ll = new LinkedListDeque<>();
        ll.addFirst(4);
        ll.addLast(12);
        ll.printDeque();
        System.out.println(ll.get(0));
        System.out.println(ll.getRecursive(0));
    }
}
