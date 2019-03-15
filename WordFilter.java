/**
 * Created by pradyumna on 12/23/18.
 */

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */

public class WordFilter {

    public WordFilter(String[] words) {

    }

    public int f(String prefix, String suffix) {
        return 0;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abc", "def"};
        String prefix = "a";
        String suffix = "f";

        WordFilter obj = new WordFilter(words);
        int param_1 = obj.f(prefix,suffix);
    }

}
