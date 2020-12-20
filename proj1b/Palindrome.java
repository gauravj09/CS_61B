public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> lld = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            lld.addLast(word.charAt(i));
        }

        return lld;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        if (palindromeHelper(deque)) {
            return true;
        }

        while (deque.removeFirst() == deque.removeLast()) {
            if (palindromeHelper(deque)) {
                return true;
            }
        }

        return false;
    }

    private boolean palindromeHelper(Deque<Character> deque) {
        return deque.size() == 0 || deque.size() == 1;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        if (palindromeHelper(deque)) {
            return true;
        }

        while (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            if (palindromeHelper(deque)) {
                return true;
            }
        }

        return false;
    }

}

