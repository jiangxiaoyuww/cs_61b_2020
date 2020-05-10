import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome() {
        String w1 = "Hello";
        String w2 = "bab";
        String w3 = "Basb";
        String w4 = "cat";
        String w5 = "TAT";
        org.junit.Assert.assertFalse(palindrome.isPalindrome(w1));
        org.junit.Assert.assertTrue(palindrome.isPalindrome(w2));
        org.junit.Assert.assertFalse(palindrome.isPalindrome(w3));
        org.junit.Assert.assertFalse(palindrome.isPalindrome(w4));
        org.junit.Assert.assertTrue(palindrome.isPalindrome(w5));
        CharacterComparator c = new OffByOne();
        org.junit.Assert.assertFalse(palindrome.isPalindrome("bab", c));
        org.junit.Assert.assertTrue(palindrome.isPalindrome("aab", c));
    }
}
