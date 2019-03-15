import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by pradyumna on 1/17/19.
 */
public class MinimumWindowSubstring {

    private boolean checkMapEquality (Map<Character, Integer> letterCount, Map<Character, Integer> letterMap) {
        if (letterMap == null || letterCount == null) {
            return false;
        }
        if (letterMap.keySet().size() != letterCount.keySet().size()) {
            return false;
        }
        for (Character ch : letterMap.keySet()) {
            if (!letterCount.containsKey(ch) || letterCount.get(ch) < letterMap.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> letterMap = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            letterMap.put(ch, letterMap.getOrDefault(ch, 0)+1);
        }

        Map<Character, Integer> letterCounter = new HashMap<>();

        int left = 0, right = 0;
        int minSize = Integer.MAX_VALUE;
        String minString = "";
        while (right < s.length()) {
            Character ch = s.charAt(right);
            if (letterMap.containsKey(ch)) {
                letterCounter.put(ch, letterCounter.getOrDefault(ch, 0) + 1);
            }

            while (checkMapEquality(letterCounter, letterMap) && left <= right) {
                if (minSize > right-left+1) {
                    minSize = right-left+1;
                    minString = s.substring(left, right+1);
                }
                Character excludeChar = s.charAt(left);

                if (letterCounter.containsKey(excludeChar)) {
                    letterCounter.put(excludeChar, letterCounter.get(excludeChar)-1);
                    if (letterCounter.get(excludeChar) <= 0) {
                        letterCounter.remove(excludeChar);
                    }
                }
                left++;
            }
            right++;
        }

        return minString;
    }


    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String primaryStr = "ADOBECODEBANC", keyString = "ABC";
        System.out.println(minimumWindowSubstring.minWindow(primaryStr, keyString));
    }
}
