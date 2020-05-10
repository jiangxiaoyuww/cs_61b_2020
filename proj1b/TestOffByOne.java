import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset. */

    static CharacterComparator offByOne = new OffByOne();
    @Test
    // Your tests go here.
    public void testOffByOne() {
        org.junit.Assert.assertTrue(offByOne.equalChars('a', 'b'));
        org.junit.Assert.assertTrue(offByOne.equalChars('r', 'q'));
        org.junit.Assert.assertTrue(offByOne.equalChars('&', '%'));
        org.junit.Assert.assertFalse(offByOne.equalChars('a', 'z'));
        org.junit.Assert.assertFalse(offByOne.equalChars('a', '%'));
        org.junit.Assert.assertFalse(offByOne.equalChars('a', 'A'));
    }
}
