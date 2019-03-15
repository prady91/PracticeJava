import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pradyumna on 1/12/19.
 *
 * https://leetcode.com/problems/palindrome-pairs/
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 */
public class PalindromePairs {

    static class PalindromeTrieNode {
        HashMap<Character, PalindromeTrieNode> pointers;
        int index;
        List<Integer> possiblePalindromeIndex;
        PalindromeTrieNode() {
            pointers = new HashMap<>();
            index = -1;
            possiblePalindromeIndex = new ArrayList<>();
        }
    }

    private PalindromeTrieNode root;

    private boolean isPalindrome(String word, int startIndex, int endIndex) {
        while (endIndex > startIndex) {
            if (word.charAt(startIndex) == word.charAt(endIndex)) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }

    private void addWord (String word, int index) {
        PalindromeTrieNode current = root;
        for (int i = word.length()-1; i>=0 ; i--) {
            Character ch = word.charAt(i);
            PalindromeTrieNode nextNode;
            if (!current.pointers.containsKey(ch)) {
                nextNode = new PalindromeTrieNode();
                current.pointers.put(ch, nextNode);
            } else {
                nextNode = current.pointers.get(ch);
            }
            if (isPalindrome(word, 0, i-1)) {
                nextNode.possiblePalindromeIndex.add(index);
            }
            current = nextNode;
        }
        current.index = index;
    }

    private List<Integer> searchWord (String word, int index) {

        PalindromeTrieNode current = root;
        List<Integer> palindromeIndexes = current.possiblePalindromeIndex;
        for (int i = 0; i < word.length(); i++) {
            if (current.index != -1 && isPalindrome(word, i, word.length()-1)) {
                palindromeIndexes.addAll(current.possiblePalindromeIndex);
            }

            if (current.pointers.containsKey(word.charAt(i))) {
                current = current.pointers.get(word.charAt(i));
            } else {
                return Collections.EMPTY_LIST;
            }

        }
        palindromeIndexes.addAll(current.possiblePalindromeIndex);
        return palindromeIndexes;
    }

    public List<List<Integer>> palindromePairs(String[] words) {

        root = new PalindromeTrieNode();
        List<List<Integer>> palindromePairs = new ArrayList<>();

        int index = 0;
        for (String word : words) {
            addWord(word, index++);
        }

        index = 0;
        for (String word : words) {
            List<Integer> matchingWords = searchWord(word, index);
            for (Integer matchingIndex : matchingWords) {
                if (matchingIndex == index) {
                    continue;
                }
                List<Integer> pairs = new ArrayList<>();
                pairs.add(index);
                pairs.add(matchingIndex);
                palindromePairs.add(pairs);
            }
            index++;
        }
        return palindromePairs;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        //String[] words = new String[]{"a",""};
        PalindromePairs palindromePairs = new PalindromePairs();
        List<List<Integer>> palindromePAirs = palindromePairs.palindromePairs(words);
        for (List<Integer> pairs : palindromePAirs) {
            System.out.println(pairs);
        }
    }

}
