public class BasicTester {
    public static void main(String[] args) {
//        LinkedListDeque<Integer> ll = new LinkedListDeque<>();
//        ll.addFirst(4);
//        ll.addLast(12);
//        ll.printDeque();
//        System.out.println(ll.get(0));
//        System.out.println(ll.getRecursive(0));

        ArrayDeque<Integer> arrayObj = new ArrayDeque<>();
        int count = 100;

        System.out.println("Here i go filling up my array");

        for (int i = 0; i < 8; i++) {
            arrayObj.addLast(count);
            count += 50;
        }

        arrayObj.printDeque();


        System.out.println("\nHere I go removing everything ... and more");

        for (int i = 0; i < 10; i++) {
            arrayObj.removeLast();
        }

        System.out.println("get on empty array:" + arrayObj.get(100));

        arrayObj.printDeque();
        count = 100;

        System.out.println("\nI fill everything again");

        for (int i = 0; i < 8; i++) {
            arrayObj.addLast(count);
            count += 50;
        }

        System.out.println("get 8th element: " + arrayObj.get(4));
        arrayObj.printDeque();
        System.out.println("\n------");
        System.out.println(arrayObj.size());

    }
}
