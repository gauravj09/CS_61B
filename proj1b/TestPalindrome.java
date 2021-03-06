import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void palindromeTest() {
        /*single character check */
        assertEquals(palindrome.isPalindrome("d"), true);

        /*bad input check */
        assertEquals(palindrome.isPalindrome("1a1"), true);
        assertEquals(palindrome.isPalindrome("abA"), false);
        assertEquals(palindrome.isPalindrome("aab"), false);
    }

    @Test
    public void offByPalindrome() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("elakf", offByOne));
        assertTrue(palindrome.isPalindrome("ekalf", offByOne));
        assertTrue(palindrome.isPalindrome("e21f", offByOne));
        assertFalse(palindrome.isPalindrome("aa", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));

        CharacterComparator offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("af", offBy5));
        assertTrue(palindrome.isPalindrome("fa", offBy5));
        assertFalse(palindrome.isPalindrome("fh", offBy5));
    }
}
