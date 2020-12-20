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

        return recursivePalindromeHelper(word, 0, word.length() - 1);
    }

    private boolean recursivePalindromeHelper(String word, int frontPtr, int backPtr) {
        if (frontPtr >= backPtr) {
            return true;
        }

        if (word.charAt(frontPtr) != word.charAt(backPtr)) {
            return false;
        }

        return recursivePalindromeHelper(word, frontPtr + 1, backPtr - 1);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        return recursiveCCHelper(word, cc, 0, word.length() - 1);
    }

    private boolean recursiveCCHelper(String word, CharacterComparator cc, int frontPtr, int backPtr) {
        if (frontPtr >= backPtr) {
            return true;
        }

        if (cc.equalChars(word.charAt(frontPtr), word.charAt(backPtr))) {
            return false;
        }

        return recursivePalindromeHelper(word, frontPtr + 1, backPtr - 1);
    }
}
