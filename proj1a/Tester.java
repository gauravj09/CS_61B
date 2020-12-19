public class Tester {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addLast(0);
        System.out.println(ArrayDeque.removeFirst()); //==> 0
        ArrayDeque.addFirst(2);
        System.out.println(ArrayDeque.removeFirst());  //==>2
        ArrayDeque.addFirst(4);
        ArrayDeque.addLast(5);
        System.out.println(ArrayDeque.get(0)); //==>4
        ArrayDeque.addLast(7);
        System.out.println(ArrayDeque.removeLast()); //==>7
        System.out.println(ArrayDeque.get(0));//==>4;
        System.out.println(ArrayDeque.get(1));//==>5;
        System.out.println(ArrayDeque.get(1)); //==>5;
        ArrayDeque.addLast(12);
        ArrayDeque.addFirst(13);
        ArrayDeque.addFirst(14);
        ArrayDeque.addLast(15);
        ArrayDeque.addFirst(16);
        ArrayDeque.addFirst(17);
        ArrayDeque.get(0);
        System.out.println(ArrayDeque.get(0)); //==>17
        ArrayDeque.addFirst(19);
    }
}
