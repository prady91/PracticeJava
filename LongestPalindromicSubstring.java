/**
 * Created by pradyumna on 6/7/18.
 */
public class LongestPalindromicSubstring {


    public String getLongestPalindromeSubstring(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int max = 1, st = 0, l = s.length();

        for (int i = 1; i < 2*s.length()-1; i++) {

            int curLen = 0, left ,right;
            if (i%2 == 0) {
                curLen = 1;
                left = i/2 - 1;
                right = i/2 + 1;
            } else {
                left = i/2;
                right = left + 1;
            }
            Character c1, c2;
            while (left >= 0 && right < l) {
                c1 = s.charAt(left);
                c2 = s.charAt(right);
                if (!c1.equals(c2)) {
                    break;
                }
                left--;
                right++;
                curLen += 2;
            }
            if (curLen > max) {
                max = curLen;
                st = i;
            }
        }

        return s.substring(st/2 - max/2 + (st%2), st/2 + max/2 + 1);
    }



    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String input = "babad";
        System.out.println(longestPalindromicSubstring.getLongestPalindromeSubstring(input));
    }
}
