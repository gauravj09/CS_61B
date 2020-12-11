public class Tester {
    public static void main(String[] args) {
        int count = 10;

        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            ArrayDeque.addLast(count);
            count += 10;
        }

        ArrayDeque.printDeque();
        System.out.println(ArrayDeque.removeLast());


    }
}