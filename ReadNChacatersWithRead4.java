/**
 * Created by pradyumna on 2/8/19.
 *
 *
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNChacatersWithRead4 {

    public int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {

        char[] tmpBuffer = new char[4];
        int currReadCharacters, totalReadCharacters = 0, remaining = n;
        while (remaining >= 0 &&  (currReadCharacters = read4(tmpBuffer)) > 0) {
            totalReadCharacters += currReadCharacters;
            remaining -= currReadCharacters;
        }

        return totalReadCharacters;
    }
}
