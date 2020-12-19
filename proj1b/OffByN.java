public class OffByN extends Palindrome implements CharacterComparator {
    private int differenceOfN;

    public OffByN(int n) {
        super();
        differenceOfN = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == differenceOfN;
    }

    @Override
    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }

        return offByOnePalindromeHelper(word, 0, word.length() - 1);
    }

    private boolean offByOnePalindromeHelper(String word, int frontPtr, int backPtr) {
        if (frontPtr >= backPtr) {
            return true;
        }

        if (!(equalChars(word.charAt(frontPtr), word.charAt(backPtr)))) {
            return false;
        }

        return offByOnePalindromeHelper(word, frontPtr + 1, backPtr - 1);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(word);
    }
}
