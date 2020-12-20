import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void equalCharsTest() {
        assertEquals(offByOne.equalChars('b', 'a'), true);
        assertEquals(offByOne.equalChars('a', 'a'), false);
        assertEquals(offByOne.equalChars('&', '%'), true);
        assertEquals(offByOne.equalChars('z', 'a'), false);
        assertEquals(offByOne.equalChars('a', 'B'), false);
    }
}
