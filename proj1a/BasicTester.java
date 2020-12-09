public class BasicTester {
    public static void main(String[] args) {
//        LinkedListDeque<Integer> ll = new LinkedListDeque<>();
//        ll.addFirst(4);
//        ll.addLast(12);
//        ll.printDeque();
//        System.out.println(ll.get(0));
//        System.out.println(ll.getRecursive(0));

        ArrayDeque<Integer> arrayObj = new ArrayDeque<>();
        int count = 7;
        int difficultCount = 10;

        for (int i = 0; i < 8; i++) {
            arrayObj.addFirst(count);
            count += 3;
        }

        arrayObj.printDeque();
        System.out.println("--------------");

        for (int i = 0; i < 16; i++) {
            arrayObj.addLast(difficultCount);
            difficultCount += 10;
        }

        arrayObj.printDeque();
    }
}
