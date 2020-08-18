public class HelloNumbers {
    public static void main(String[] args) {
        int sum = 0;

        for(int number = 0; number <= 9; number++) {
            sum += number;
            System.out.print(sum + " ");
        }

    }
}