public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> lld = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            lld.addLast(word.charAt(i));
        }

        return lld;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        return recursiveHelper(word, 0, word.length() - 1);
    }

    private boolean recursiveHelper(String word, int frontPtr, int backPtr) {
        if (word.charAt(frontPtr) != word.charAt(backPtr)) {
            return false;
        }

        if (frontPtr >= backPtr) {
            return true;
        }

        return recursiveHelper(word, frontPtr + 1, backPtr - 1);
    }
}
