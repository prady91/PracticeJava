import java.util.*;

/**
 * Created by pradyumna on 5/27/18.
 */

/*
Given a string, find the length of the longest substring without repeating characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

public class LongestSubstringUniqueCharacters {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, maxLen = 0, endIndex = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (!charMap.containsKey(s.charAt(i)) || charMap.get(s.charAt(i)) < i - l) {
                charMap.put(s.charAt(i), i);
                l++;
                if (maxLen < l) {
                    maxLen = l;
                    endIndex = i;
                }
            } else {
                int prevIndex = charMap.get(s.charAt(i));
                charMap.put(s.charAt(i), i);
                l = i - prevIndex;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {

        LongestSubstringUniqueCharacters testObj = new LongestSubstringUniqueCharacters();
        System.out.println(testObj.lengthOfLongestSubstring("abbb"));
        System.out.println(testObj.lengthOfLongestSubstring("abbbca"));
        System.out.println(testObj.lengthOfLongestSubstring("pwwkew"));

    }

}
