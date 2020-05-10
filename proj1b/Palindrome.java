public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ans = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> ans = wordToDeque(word);
        while (ans.size() > 1) {
            if (ans.removeFirst() != ans.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator c) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> ans = wordToDeque(word);
        while (ans.size() > 1) {
            if (!(c.equalChars(ans.removeFirst(), ans.removeLast()))) {
                return false;
            }
        }
        return true;
    }
}
