/**
 * Created by pradyumna on 12/23/18.
 */
public class Trie {

    private TrieNode root;

    static class TrieNode {
        TrieNode[] pointers;
        Boolean isWord;
        TrieNode () {
            pointers = new TrieNode[26];
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        TrieNode current = root;
        for (Character ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            TrieNode next = current.pointers[index];
            if (next == null) {
                current.pointers[index] = new TrieNode();
            }
            current = current.pointers[index];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        TrieNode current = root;
        for (Character ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (current.pointers[index] == null) {
                return false;
            }
            current = current.pointers[index];
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        TrieNode current = root;
        for (Character ch : prefix.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (current.pointers[index] == null) {
                return false;
            }
            current = current.pointers[index];
        }
        return true;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abd");

        Boolean result = trie.startsWith("a");
        System.out.println(result);

        result = trie.startsWith("abc");
        System.out.println(result);
    }
}
